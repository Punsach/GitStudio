import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class CerealDataProcessor {
    List<Cereal> cerealData;

    public CerealDataProcessor(List<Cereal> cereals) {
        this.cerealData = cereals;
    }

    public float getMedianValue(Constants.CEREAL_PROPERTIES cp) {
        Collections.sort(this.cerealData, new Comparator<Cereal>() {
            @Override
            public int compare(Cereal o1, Cereal o2) {
                Float fo1 = o1.getProperty(cp);
                Float fo2 = o1.getProperty(cp);
                return fo1.compareTo(fo2);
            }
        });

        int medianIndex = this.cerealData.size() / 2;
        return this.cerealData.get(medianIndex).getProperty(cp);
    }

}

