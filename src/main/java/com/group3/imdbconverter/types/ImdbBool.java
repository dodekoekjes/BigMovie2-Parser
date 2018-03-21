package com.group3.imdbconverter.types;


public final class ImdbBool extends ImdbType<Boolean>
{
   @Override
   public String toString()
   {
      if (m_empty)
      {
         return "";
      }

      return m_value
         ? "1"
         : "0";
   }

   public static ImdbBool parse(String str)
   {
      ImdbBool ret = new ImdbBool();

      if (str.equals("\\N"))
      {
         ret.m_empty = true;
         return ret;
      }

      ret.m_value = str.equals("1")
         ? true
         : false;

      return ret;
   }
}
