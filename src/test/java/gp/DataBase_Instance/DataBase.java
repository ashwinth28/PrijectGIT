package gp.DataBase_Instance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

	// Local
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ecinv";
	private static final String DB_USER = "ecinvuser";
	private static final String DB_PASSWORD = "ecuser123";

	// QA Env
//	private static final String DB_URL = "jdbc:mysql://13.232.10.202:3306/ecinv";
//	private static final String DB_USER = "test_erpqa";
//	private static final String DB_PASSWORD = "erpqa123";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public static List<CRMData> getIssueData(String soNoList) throws SQLException {
		List<CRMData> issueList = new ArrayList<CRMData>();
		String query1 = "select so_num, reg.issue_dispname, " + "case when (req_id = 2) then ( "
				+ "case when (select (if(prod.pr_rev_id is not null, concat(prod.productcode , rev.rev_name), prod.productcode)) "
				+ "			from product prod left join pr_revision rev on  prod.pr_rev_id = rev.pr_rev_id "
				+ "			where productid = reg.cust_product_id) is not null "
				+ "     then (select (if(prod.pr_rev_id is not null, concat(prod.productcode , rev.rev_name), prod.productcode)) "
				+ "			from product prod left join pr_revision rev on  prod.pr_rev_id = rev.pr_rev_id "
				+ "			where productid = reg.cust_product_id)       "
				+ "     else  (select mpncode from mpn mpn left join mpn_revision mpn_rev on mpn_rev.mpn_rev_id = mpn.mpn_rev_id "
				+ "					   where mpn_id = (select ppn_id from componentissuedetail issue_det where issue_det.ir_id = reg.ir_id limit 1))       "
				+ "     end) "
				+ "     else (case when (select (if(prod.pr_rev_id is not null, concat(prod.productcode , rev.rev_name), prod.productcode)) "
				+ "			from product prod left join pr_revision rev on  prod.pr_rev_id = rev.pr_rev_id "
				+ "			where productid = reg.product_id) is not null "
				+ "     then (select (if(prod.pr_rev_id is not null, concat(prod.productcode , rev.rev_name), prod.productcode)) "
				+ "			from product prod left join pr_revision rev on  prod.pr_rev_id = rev.pr_rev_id "
				+ "			where productid = reg.product_id)       "
				+ "     else  (select epncode from mech_epn where material_id = (select material_id "
				+ "					  from componentissuedetail issue_det where issue_det.ir_id = reg.ir_id limit 1)) "
				+ "                      end) " + "     end as product_code, "
				+ " (select name from status s where s.status_id = reg.status_id) as statusname, "
				+ " inv.invoice_number_seq, " 
				+ " inv.invoice_date, (select grn_date from grn_fg_register where ir_id = reg.ir_id) as grn_date "
				+ " from componentissueregister reg "
//				+ " right join grn_fg_register fg on fg.ir_id = reg.ir_id" 
				+ " left join crm_invoices inv on inv.so_no = reg.so_num"
				+ " where reg.so_num in ( " + soNoList + " ) having statusname != 'Cancelled' ";
		System.out.println(query1);

		try (Connection connection = getConnection();
				PreparedStatement statement1 = connection.prepareStatement(query1)) {
			statement1.setFetchSize(2000);
			try (ResultSet resultSet1 = statement1.executeQuery()) {

				int size = 0;
				while (resultSet1.next()) {
					CRMData data = new CRMData();
					data.setSo_no(resultSet1.getString("so_num"));
					data.setIssue_name(resultSet1.getString("issue_dispname"));
					data.setProduct_code(resultSet1.getString("product_code"));
					data.setIssue_status(resultSet1.getString("statusname"));
					data.setInvoice_date(resultSet1.getDate("invoice_date"));
					data.setInvoice_no(resultSet1.getString("invoice_number_seq"));
					data.setGrn_date(resultSet1.getString("grn_date"));
					issueList.add(data);

					size++;

				}
				System.out.println("Size: " + size);

				return issueList;
			}

		}
	}

	public static List<CRMData> getSoNo(String username) throws SQLException {
		ArrayList soNos = new ArrayList();
		ArrayList<CRMData> invoice = new ArrayList<CRMData>();
		ArrayList getValue = new ArrayList<>();

		// Original Query Previous Date
//		String query1 = "select inv.so_no, inv.invoice_number_seq,od.quantity,inv.invoice_date, od.product_code "
//				+ " from crm_invoices inv " + "inner join crm_orders od on od.so_no = inv.so_no "
//				+ " where inv.invoice_date = (CASE "
//				+ " WHEN DAYOFWEEK(CURRENT_DATE()) = 2 THEN CURRENT_DATE() - INTERVAL 2 DAY"
//				+ " ELSE CURRENT_DATE() - INTERVAL 1 DAY "
//				+ " END) and od.status in ('Delivered','Shipped','Invoiced');";

		// Month Wise Data Query
		String query1 = "select concat(inv.so_no,'') as so_no, inv.invoice_number_seq,od.quantity,inv.invoice_date, od.product_code "
				+ "from crm_invoices inv inner join crm_orders od on od.so_no = inv.so_no "
				+ "where inv.invoice_date between '2024-06-01' and '2024-06-04'"
				+ "and od.status in ('Delivered','Shipped','Invoiced')"
//				+ "and inv.invoice_status != 'Created' "
				+ "order by invoice_date asc;";

		System.out.println(query1);

		try (Connection connection = getConnection();
				PreparedStatement statement1 = connection.prepareStatement(query1)) {
			statement1.setFetchSize(2000);

			try (ResultSet resultSet1 = statement1.executeQuery()) {

				int size = 0;
				while (resultSet1.next()) {
					CRMData data = new CRMData();
					data.setSo_no(resultSet1.getString("so_no"));
					data.setInvoice_no(resultSet1.getString("invoice_number_seq"));
					data.setQty(resultSet1.getInt("quantity"));
					data.setInvoice_date(resultSet1.getDate("invoice_date"));
					data.setProduct_code(resultSet1.getString("product_code"));

					invoice.add(data);

					size++;

				}
				System.out.println("Size: " + size);

				return invoice;
			}
		}

	}
}
