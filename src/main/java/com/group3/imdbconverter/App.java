package com.group3.imdbconverter;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.group3.imdbconverter.base.Converter;
import com.group3.imdbconverter.readers.*;
import com.group3.imdbconverter.writers.*;

import com.group3.csv2mysql.toMysql;


public final class App
{

   public static void main(String[] args)
      throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
   {
      String input = "/home/smug/Documents/Informatica/J2/BigData/poging2/tsv/";
      String output = "/home/smug/Documents/Informatica/J2/BigData/poging2/data/csv/";

    //  // tomysql by eldert
    //   toMysql c = new toMysql();
    //   try{
    //     // create map witch points to te csv files (par1) and table title (par2)
    //     Map<String, String> map = new HashMap<String, String>();
    //     //map.put("title.basics.csv", "title");
    //     map.put("name.basics.csv", "name");
    //     map.put("title.episode.csv", "episode");
    //     map.put("title.basics.genre.csv", "genre");
    //     map.put("name.basics.title", "name_known_for_titles");
    //     map.put("name.basics.profession", "name_profession");

    //     Iterator it = map.entrySet().iterator();
    //       while (it.hasNext()) {
    //           Map.Entry pair = (Map.Entry)it.next();
    //           c.csvToSql(output, pair.getKey().toString(), pair.getValue().toString());
    //           it.remove(); // avoids a ConcurrentModificationException
    //       }
          
    //     if(c.csvToSql(output, "title.basics.csv", "title"))
    //       System.out.println("title.basics.csv has been imported");

    //   } catch(SQLException e){
    //       // on sql error
    //       System.out.println(e);
    //   } finally {
    //     //close db connection
    //      c.close();
    //   }

      // Converter.conversions()
      //    .add(new NameBasicsReader(input + "name.basics.tsv"), new NameBasicsWriter(output))
      //    .add(new TitleBasicsReader(input + "title.basics.tsv"), new TitleBasicsWriter(output))
      //    .add(new TitleCrewReader(input + "title.crew.tsv"), new TitleCrewWriter(output))
      //    .add(new TitleEpisodeReader(input + "title.episode.tsv"), new TitleEpisodeWriter(output))
      //    .add(new TitlePrincipalReader(input + "title.principals.tsv"), new TitlePrincipalWriter(output))
      //    .add(new TitleRatingReader(input + "title.ratings.tsv"), new TitleRatingWriter(output))
      //    .start();

      Converter.conversions()
         .add(new TitleBasicsReader(input + "title.basics.tsv"), new TitleBasicsWriter(output))
         .start();
      
   }
}
