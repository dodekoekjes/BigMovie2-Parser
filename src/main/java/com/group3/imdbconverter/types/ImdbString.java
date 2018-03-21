package com.group3.imdbconverter.types;


public final class ImdbString extends ImdbType<String>
{
   public static ImdbString parse(String str)
   {
      ImdbString ret = new ImdbString();

      if (str.equals("\\N"))
      {
         ret.m_empty = true;
         return ret;
      }

      ret.m_value = "\"" + str + "\"";
      return ret;
   }
}
