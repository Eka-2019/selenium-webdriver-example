package base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest{

    @DataProvider(name="files")
    protected static Object[][] uploadingFiles(){
        return new Object[][]{
                {1, "OfficeZoom.jpg"},
                {2, "text.txt"}
        };
    }
}
