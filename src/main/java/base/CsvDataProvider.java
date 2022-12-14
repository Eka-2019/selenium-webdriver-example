package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class CsvDataProvider {

    @DataProvider(name = "csvReadr")
    public static Iterator<Object[]> csvReader(Method method) {
        List<Object[]> list = new ArrayList<>();
        String pathName = "src/test/resources/testdataprovider/NegativeLoginTestCSVDataProvider/negativeLoginTestData.csv";
        //String pathName = "src/test/resources/testdataprovider/" + method.getDeclaringClass().getSimpleName() + File.separator + method.getName() + ".csv";
//        String pathName = "src" + File.separator + "test" + File.separator + "resources" + File.separator
//                + "dataproviders" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
//                + method.getName() + ".csv";
        File file = new File(pathName);
        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (keys != null) {
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null){
                    Map<String, String> testData = new HashMap<>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[i], dataParts[i]);
                    }
                    list.add(new Object[]{testData});
                }
            }
            reader.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException("File" + pathName + " was not found.\n" + e.getStackTrace().toString());
        }catch (IOException e){
            throw new RuntimeException("Could not read"  + pathName + " file.\n" + e.getStackTrace().toString());
        } catch (CsvValidationException e) {
            throw new RuntimeException("CSV file" + pathName+ " validation is failed" + e.getStackTrace().toString());
        }
        return list.iterator();
    }
}
