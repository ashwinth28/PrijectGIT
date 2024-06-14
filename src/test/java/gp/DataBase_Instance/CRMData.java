package gp.DataBase_Instance;

import java.util.Date;

public class CRMData {

	private String so_no;
	private String invoice_no;
	private int qty;
	private Date invoice_date;
	private String invoice_status;
	private String product_code;
	private boolean isProductMisMatch;
	private boolean isQtyMismatch;
	private String issue_name;
	private String issue_status;
	private String grn_date;
	private String crm_typeof_orderl;
	private String owner_name;
	private String account_name;
	private String market_area;
	private String unitprice_usd;
	private String mat_value_realized_usd;
	private String mat_value_incurred_usd;
	private String inward_frieght_incurred_usd;
	private String packing_material;
	private String others_incurred;
	private String cost_incurred;
	private String gp_excluding_freight;
	private String gp_excluding_freight_inpercentage;
	private String freight_realized;
	private String invoice_value;
	private String freight_incurred;
	private String cost_incurred_incl_freight;
	private String gross_profit;
	private String gross_profit_percentage;
	private String ui_gross_profit_percentage;
	private String excel_gross_profit_percentage;
	private String gross_profit_percentage_diff;
	private boolean gpmatch;
	
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(Date date) {
		this.invoice_date = date;
	}
	public String getInvoice_status() {
		return invoice_status;
	}
	public void setInvoice_status(String invoice_status) {
		this.invoice_status = invoice_status;
	}
	public String getSo_no() {
		return so_no;
	}
	public void setSo_no(String so_no) {
		this.so_no = so_no;
	}
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	@Override
	public String toString() {
		return "CRMData [so_no=" + so_no + ", invoice_no=" + invoice_no + ", qty=" + qty + ", invoice_date="
				+ invoice_date + ", invoice_status=" + invoice_status + ", product_code=" + product_code + gpmatch + gross_profit_percentage + "]";
	}
	public boolean isProductMisMatch() {
		return isProductMisMatch;
	}
	public void setProductMisMatch(boolean isProductMisMatch) {
		this.isProductMisMatch = isProductMisMatch;
	}
	public boolean isQtyMismatch() {
		return isQtyMismatch;
	}
	public void setQtyMismatch(boolean isQtyMismatch) {
		this.isQtyMismatch = isQtyMismatch;
	}
	public String getIssue_name() {
		return issue_name;
	}
	public void setIssue_name(String issue_name) {
		this.issue_name = issue_name;
	}
	public String getIssue_status() {
		return issue_status;
	}
	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}
	public String getGrn_date() {
		return grn_date;
	}
	public void setGrn_date(String grn_date) {
		this.grn_date = grn_date;
	}
	public String getCrm_typeof_orderl() {
		return crm_typeof_orderl;
	}
	public void setCrm_typeof_orderl(String crm_typeof_orderl) {
		this.crm_typeof_orderl = crm_typeof_orderl;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getMarket_area() {
		return market_area;
	}
	public void setMarket_area(String market_area) {
		this.market_area = market_area;
	}
	public String getUnitprice_usd() {
		return unitprice_usd;
	}
	public void setUnitprice_usd(String unitprice_usd) {
		this.unitprice_usd = unitprice_usd;
	}
	public String getMat_value_realized_usd() {
		return mat_value_realized_usd;
	}
	public void setMat_value_realized_usd(String mat_value_realized_usd) {
		this.mat_value_realized_usd = mat_value_realized_usd;
	}
	public String getMat_value_incurred_usd() {
		return mat_value_incurred_usd;
	}
	public void setMat_value_incurred_usd(String mat_value_incurred_usd) {
		this.mat_value_incurred_usd = mat_value_incurred_usd;
	}
	public String getInward_frieght_incurred_usd() {
		return inward_frieght_incurred_usd;
	}
	public void setInward_frieght_incurred_usd(String inward_frieght_incurred_usd) {
		this.inward_frieght_incurred_usd = inward_frieght_incurred_usd;
	}
	public String getPacking_material() {
		return packing_material;
	}
	public void setPacking_material(String packing_material) {
		this.packing_material = packing_material;
	}
	public String getOthers_incurred() {
		return others_incurred;
	}
	public void setOthers_incurred(String others_incurred) {
		this.others_incurred = others_incurred;
	}
	public String getCost_incurred() {
		return cost_incurred;
	}
	public void setCost_incurred(String cost_incurred) {
		this.cost_incurred = cost_incurred;
	}
	public String getGp_excluding_freight() {
		return gp_excluding_freight;
	}
	public void setGp_excluding_freight(String gp_excluding_freight) {
		this.gp_excluding_freight = gp_excluding_freight;
	}
	public String getGp_excluding_freight_inpercentage() {
		return gp_excluding_freight_inpercentage;
	}
	public void setGp_excluding_freight_inpercentage(String gp_excluding_freight_inpercentage) {
		this.gp_excluding_freight_inpercentage = gp_excluding_freight_inpercentage;
	}
	public String getFreight_realized() {
		return freight_realized;
	}
	public void setFreight_realized(String freight_realized) {
		this.freight_realized = freight_realized;
	}
	public String getInvoice_value() {
		return invoice_value;
	}
	public void setInvoice_value(String invoice_value) {
		this.invoice_value = invoice_value;
	}
	public String getFreight_incurred() {
		return freight_incurred;
	}
	public void setFreight_incurred(String freight_incurred) {
		this.freight_incurred = freight_incurred;
	}
	public String getCost_incurred_incl_freight() {
		return cost_incurred_incl_freight;
	}
	public void setCost_incurred_incl_freight(String cost_incurred_incl_freight) {
		this.cost_incurred_incl_freight = cost_incurred_incl_freight;
	}
	public String getGross_profit_percentage() {
		return gross_profit_percentage;
	}
	public void setGross_profit_percentage(String gross_profit_percentage) {
		this.gross_profit_percentage = gross_profit_percentage;
	}
	public String getGross_profit() {
		return gross_profit;
	}
	public void setGross_profit(String gross_profit) {
		this.gross_profit = gross_profit;
	}
	public boolean isGpmatch() {
		return gpmatch;
	}
	public void setGpmatch(boolean gpmatch) {
		this.gpmatch = gpmatch;
	}
	public String getUi_gross_profit_percentage() {
		return ui_gross_profit_percentage;
	}
	public void setUi_gross_profit_percentage(String ui_gross_profit_percentage) {
		this.ui_gross_profit_percentage = ui_gross_profit_percentage;
	}
	public String getExcel_gross_profit_percentage() {
		return excel_gross_profit_percentage;
	}
	public void setExcel_gross_profit_percentage(String excel_gross_profit_percentage) {
		this.excel_gross_profit_percentage = excel_gross_profit_percentage;
	}
	public String getGross_profit_percentage_diff() {
		return gross_profit_percentage_diff;
	}
	public void setGross_profit_percentage_diff(String gross_profit_percentage_diff) {
		this.gross_profit_percentage_diff = gross_profit_percentage_diff;
	}
	
	
}
