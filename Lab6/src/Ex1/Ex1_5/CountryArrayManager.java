package Ex1.Ex1_5;

public class CountryArrayManager {
    private Country[] countries;
    private int length;
    private int increment;

    public CountryArrayManager() {
        this.increment = 10;
        countries = new Country[this.increment];
        this.length = 0;
    }

    public CountryArrayManager(int maxLength) {
        this.length = 0;
        this.increment = 10;
        countries = new Country[maxLength];
    }

    public int getLength() {
        return length;
    }

    public Country[] getCountries() {
        return countries;
    }

    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }
        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex;
            for (int i = nullFirstIndex; i < this.countries.length; i++) {
                this.countries[i] = null;
            }
        }
    }

    private void allocateMore() {
        Country[] newArray = new Country[this.countries.length + this.increment];
        System.arraycopy(this.countries, 0, newArray, 0, this.countries.length);
        this.countries = newArray;
    }

    public void append(Country country) {
        if (this.length >= this.countries.length) {
            allocateMore();
        }

        this.countries[this.length] = country;
        this.length++;
    }

    public boolean add(Country country, int index) {
        if ((index < 0) || (index > this.countries.length)) {
            return false;
        }

        if (this.length >= this.countries.length) {
            allocateMore();
        }

        for (int i = this.length; i > index; i--) {
            this.countries[i] = this.countries[i - 1];
        }

        this.countries[index] = country;
        this.length++;
        return true;
    }

    public boolean remove(int index) {
        if ((index < 0) || (index >= countries.length)) {
            return false;
        }

        for (int i = index; i < length - 1; i++) {
            this.countries[i] = this.countries[i + 1];
        }

        this.countries[this.length - 1] = null;
        this.length--;
        return true;
    }

    public Country countryAt(int index) {
        if ((index < 0) || (index >= this.length)) {
            return null;
        }

        return this.countries[index];
    }

    /**
     * Sort the countries in order of increasing population
     * using selection sort algorithm.
     *
     * @return array of increasing population countries.
     */
    public Country[] sortByIncreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 0; i < this.length; i++) {
            int index = i;
            for (int j = i + 1; j < this.length; j++) {
                if (newArray[i].getPopulation() < newArray[index].getPopulation()) {
                    index = j;
                }
            }
            Country temp = newArray[index];
            newArray[index] = newArray[i];
            newArray[i] = temp;
        }

        return newArray;
    }

    /**
     * Sort the countries in order of decreasing population
     * using selection sort algorithm.
     *
     * @return array of decreasing population countries.
     */
    public Country[] sortByDecreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 0; i < this.length; i++) {
            int index = i;
            for (int j = i + 1; j < this.length; j++) {
                if (newArray[i].getPopulation() > newArray[index].getPopulation()) {
                    index = j;
                }
            }
            Country temp = newArray[index];
            newArray[index] = newArray[i];
            newArray[i] = temp;
        }

        return newArray;
    }

    /**
     * Sort the countries in order of increasing area
     * using bubble sort algorithm.
     *
     * @return array of increasing area countries.
     */
    public Country[] sortByIncreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        boolean swapped = false;
        for (int i = 0; i < this.length; i++) {
            swapped = false;
            for (int j = 0; j < this.length - 1 - i; j++) {
                if (newArray[j].getArea() > newArray[j + 1].getArea()) {
                    Country temp = newArray[j + 1];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;

                    swapped = true;
                }
            }
            if (!swapped) break;
        }


        return newArray;
    }

    /**
     * Sort the countries in order of decreasing area
     * using bubble sort algorithm.
     *
     * @return array of increasing area countries.
     */
    public Country[] sortByDecreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        boolean swapped = false;
        for (int i = 0; i < this.length; i++) {
            swapped = false;
            for (int j = 0; j < this.length - 1 - i; j++) {
                if (newArray[j].getArea() < newArray[j + 1].getArea()) {
                    Country temp = newArray[j + 1];
                    newArray[j] = newArray[j + 1];
                    newArray[j + 1] = temp;

                    swapped = true;
                }
            }
            if (!swapped) break;
        }


        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     * using insertion sort algorithm.
     *
     * @return array of increasing GDP countries.
     */
    public Country[] sortByIncreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        /* TODO */
        for (int i = 1; i < this.length; i++) {
            Country temp = newArray[i];
            int j = i - 1;
            while (j >= 0 && newArray[j].getGdp() > temp.getGdp()) {
                newArray[j + 1] = newArray[j];
                j--;
            }
            newArray[j + 1] = temp;
        }

        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     * using insertion sort algorithm.
     *
     * @return array of increasing insertion countries.
     */
    public Country[] sortByDecreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);

        for (int i = 1; i < this.length; i++) {
            Country temp = newArray[i];
            int j = i - 1;
            while (j >= 0 && newArray[j].getGdp() < temp.getGdp()) {
                newArray[j + 1] = newArray[j];
                j--;
            }
            newArray[j + 1] = temp;
        }

        return newArray;
    }

    public AfricaCountry[] filterAfricaCountry() {
        int n = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] instanceof AfricaCountry) {
                n++;
            }
        }
        AfricaCountry[] array = new AfricaCountry[n];
        int j = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] instanceof AfricaCountry) {
                array[j] = (AfricaCountry) this.countries[i];
                j++;
            }
        }
        return array;

    }

    public AsiaCountry[] filterAsiaCountry() {
        int n = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof AsiaCountry) {
                n++;
            }
        }
        AsiaCountry[] array = new AsiaCountry[n];
        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof AsiaCountry) {
                array[j] = (AsiaCountry) this.countries[i];
                j++;
            }
        }
        return array;
    }

    public EuropeCountry[] filterEuropeCountry() {
        int n = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof EuropeCountry) {
                n++;
            }
        }
        EuropeCountry[] array = new EuropeCountry[n];
        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof EuropeCountry) {
                array[j] = (EuropeCountry) this.countries[i];
                j++;
            }
        }
        return array;
    }

    public NorthAmericaCountry[] filterNorthAmericaCountry() {
        int n = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof NorthAmericaCountry) {
                n++;
            }
        }
        NorthAmericaCountry[] array = new NorthAmericaCountry[n];
        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof NorthAmericaCountry) {
                array[j] = (NorthAmericaCountry) this.countries[i];
                j++;
            }
        }
        return array;
    }

    public OceaniaCountry[] filterOceaniaCountry() {
        /* TODO */
        int n = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof OceaniaCountry) {
                n++;
            }
        }
        OceaniaCountry[] array = new OceaniaCountry[n];
        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof OceaniaCountry) {
                array[j] = (OceaniaCountry) this.countries[i];
                j++;
            }
        }
        return array;
    }

    public SouthAmericaCountry[] filterSouthAmericaCountry() {
        int n = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof SouthAmericaCountry) {
                n++;
            }
        }
        SouthAmericaCountry[] array = new SouthAmericaCountry[n];
        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.countries[i] instanceof SouthAmericaCountry) {
                array[j] = (SouthAmericaCountry) this.countries[i];
                j++;
            }
        }
        return array;
    }

    public Country[] filterMostPopulousCountries(int howMany) {
        Country[] array = sortByDecreasingPopulation();
        Country[] returnArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            if (i < array.length) {
                returnArray[i] = array[i];
            } else {
                returnArray[i] = null;
            }
        }
        return returnArray;
    }

    public Country[] filterLeastPopulousCountries(int howMany) {
        /* TODO */
        Country[] array = sortByIncreasingPopulation();
        Country[] returnArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            if (i < array.length) {
                returnArray[i] = array[i];
            } else {
                returnArray[i] = null;
            }
        }
        return returnArray;
    }

    public Country[] filterLargestAreaCountries(int howMany) {
        /* TODO */
        Country[] array = sortByDecreasingArea();
        Country[] returnArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            if (i < array.length) {
                returnArray[i] = array[i];
            } else {
                returnArray[i] = null;
            }
        }
        return returnArray;
    }

    public Country[] filterSmallestAreaCountries(int howMany) {
        /* TODO */
        Country[] array = sortByIncreasingArea();
        Country[] returnArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            if (i < array.length) {
                returnArray[i] = array[i];
            } else {
                returnArray[i] = null;
            }
        }
        return returnArray;
    }

    public Country[] filterHighestGdpCountries(int howMany) {
        /* TODO */
        Country[] array = sortByDecreasingGdp();
        Country[] returnArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            if (i < array.length) {
                returnArray[i] = array[i];
            } else {
                returnArray[i] = null;
            }
        }
        return returnArray;
    }

    public Country[] filterLowestGdpCountries(int howMany) {
        /* TODO */
        Country[] array = sortByIncreasingArea();
        Country[] returnArray = new Country[howMany];
        for (int i = 0; i < howMany; i++) {
            if (i < array.length) {
                returnArray[i] = array[i];
            } else {
                returnArray[i] = null;
            }
        }
        return returnArray;
    }

    public static String codeOfCountriesToString(Country[] countries) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                codeOfCountries.append(country.getCode())
                        .append(" ");
            }
        }

        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(Country[] countries) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                countriesString.append(country.toString()).append("\n");
            }
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}
