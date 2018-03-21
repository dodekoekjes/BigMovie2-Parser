package com.group3.imdbconverter.types;


public final class ImdbId extends ImdbType<Integer>
{
   public static ImdbId from(int value)
   {
      ImdbId ret = new ImdbId();
      ret.m_value = value;
      return ret;
   }

   public static ImdbId parse(String str)
   {
      ImdbId ret = new ImdbId();

      if (str.equals("\\N"))
      {
         ret.m_empty = true;
         return ret;
      }

      int val = 0;
      for (int i = 0; i < str.length(); ++i)
      {
         char c = str.charAt(i);
         if (c >= 48 && c <= 57)
         {
            val = val * 10 + c - 48;
         }
      }

      ret.m_value = val - 1;
      return ret;
   }
}
