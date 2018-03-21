package com.group3.imdbconverter.types;

// Title type is a text parser for the right value of title.type
// By eldert
public abstract class ImdbType<T>
{
   protected T m_value;
   protected boolean m_empty;

// returns boolean m_empty (checks if is empty)
   public boolean empty()
   {
      return m_empty;
   }

// public function to return value
   public T value()
   {
      return m_value;
   }
   // Overrides to string function for title type
   @Override
   public String toString()
   {
      if (m_empty)
      {
         return "";
      }
      return m_value.toString();
   }
}
