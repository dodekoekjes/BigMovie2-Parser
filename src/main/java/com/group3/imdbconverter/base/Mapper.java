package com.group3.imdbconverter.base;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public final class Mapper
{
   private Mapper()
   {
   }
// Create Map
   public static <In, Out> List<Out> map(In[] arr, Function<In, Out> fn)
   {
      List<Out> ret = new ArrayList<>(arr.length);
      for (In item : arr)
      {
         ret.add(fn.apply(item));
      }
      return ret;
   }
}
