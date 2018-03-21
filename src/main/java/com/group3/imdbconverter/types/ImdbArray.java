package com.group3.imdbconverter.types;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.group3.imdbconverter.base.Mapper;


public final class ImdbArray
{
   public static <Out> List<Out> map(String str, Function<String, Out> fn)
   {
      return str.equals("\\N")
         ? new ArrayList<>()
         : Mapper.map(str.split("\\s?,\\s?"), fn);
   }
}
