package com.group3.imdbconverter.types;


public final class ImdbDouble extends ImdbType<Double>
{
   public static ImdbDouble parse(String str)
   {
      ImdbDouble ret = new ImdbDouble();
      try
      {
         ret.m_value = Double.parseDouble(str);
      }
      catch (NumberFormatException ex)
      {
         ret.m_empty = true;
      }
      return ret;
   }
}
