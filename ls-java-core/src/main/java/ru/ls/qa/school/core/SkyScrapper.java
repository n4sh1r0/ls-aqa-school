package ru.ls.qa.school.core;

public class SkyScrapper {

    private Integer firstFloorFlatSale;
    private Integer floorsCount;
    private Integer freqIncrease;


    public SkyScrapper(Integer firstFloorFlatSale, Integer floorsCount, Integer freqIncrease){
        this.firstFloorFlatSale = firstFloorFlatSale;
        this.floorsCount = floorsCount;
        this.freqIncrease = freqIncrease;

    }

    public Integer getFirstFloorFlatSale() {
        return firstFloorFlatSale;
    }

    public Integer getFloorsCount(){
        return floorsCount;
    }

    public Integer getFreqIncrease(){
        return freqIncrease;
    }

    public int totalGain(){

        int x = getFirstFloorFlatSale();
        int n = getFloorsCount();
        int m = getFreqIncrease();
        int sum = 0;

        for (int i = 1; i<=n; i++){
            sum += x + ((i - 1)) / m * 1000;
        }
        return sum;
    }

    public static void main(String[] args){
        SkyScrapper skyScrapper = new SkyScrapper(10000, 30, 10);
        System.out.println("Общая сумма стоимости квартир " + skyScrapper.totalGain());
    }
}