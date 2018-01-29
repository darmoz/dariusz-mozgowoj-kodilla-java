package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {

    public String[][] workers = {
            {"123256983", "John", "Smith"},
            {"847509129", "Elizabeth", "Green"},
            {"598382399", "Tom", "Bright"},
            {"394894885", "Ann", "Blithe"},
            {"678879603", "Andrew", "Horn"}};
    public double[] salaries = {
            2050,
            8100,
            2350,
            3050,
            6900
    };

    public String getWorker(int n) {
        if(n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + " ," + salaries[n];
    }

    public String[][] getWorkers(){
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
