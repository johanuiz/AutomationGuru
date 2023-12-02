package commonLibs.utils;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class ScreenshotUtils {
    private TakesScreenshot camera;
    public ScreenshotUtils(WebDriver driver){
        camera = (TakesScreenshot) driver;
    }
    public void captureAndSaveScreenShot(String filename)throws Exception{
        filename = filename.trim();
        File imgFile, tmpFile;
        imgFile = new File(filename);
        if(imgFile.exists()){
            throw new Exception(("File alredy exist"));
        }
        tmpFile =camera.getScreenshotAs(OutputType.FILE);

        FileUtils.moveFile(tmpFile, imgFile);
    }
}
