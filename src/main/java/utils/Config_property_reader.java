package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config_property_reader
{
   private  Properties config_proPerty;

    public Properties propertyreader() throws IOException
    {
        FileInputStream fileinputs=null;
        config_proPerty=new Properties();
        fileinputs=new FileInputStream("C:\\Users\\admin\\IdeaProjects\\Mattel_project\\src\\main\\resources\\configfiles\\config.properties");
        config_proPerty.load(fileinputs);
        return config_proPerty;

    }
}
