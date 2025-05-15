package org.dreamCar.contract;

public class SalesContract extends Contract {
    private double taxAmount ;
    private double recordingFee ;
    private double processingFee;
    private String finance;
//    private double monthly48Finance = 4.25;
//    private double monthly24Finance = 5.25;


    public SalesContract(String contractType,String dateOfContract, String name, String email, int vehicleSold, double taxAmount, double recordingFee, double processingFee, String finance) {
        super(contractType,dateOfContract, name, email, vehicleSold);
        this.taxAmount = taxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.finance = finance;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        finance = finance;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthPayment() {
        return 0;
    }
}
