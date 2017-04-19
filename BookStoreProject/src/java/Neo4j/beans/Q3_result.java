/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Neo4j.beans;

/**
 *
 * @author hom19
 */
public class Q3_result {
    private String product;
    private String sale;
    private String profit;

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the sale
     */
    public String getSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(String sale) {
        this.sale = sale;
    }

    /**
     * @return the profit
     */
    public String getProfit() {
        return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(String profit) {
        this.profit = profit;
    }
}
