/**
 * Creates a Vigenere Cipher table according to a given character, then encodes and decodes a message using key word/phrase. *
 * @author Steven Garrett
 * Class: CS 1131, Lab: L02
 * @version 1.2
 */
public class Prog5Cipher {
   // INSTANCE VARIABLES
   char [ ] keyList; // Array holding each character of the key word/phrase
   char [ ][ ] cipherTable = new char [26] [26]; // Array holding the Vigenere Cipher table

   // METHODS
   /**
    * Encodes a given message using the created Vigenere Cipher table and the key word/phrase. *
    * @param message The message to be encoded
    * @return The encoded message
    */
   String encode( String message ) {
      String result = "";
      int i = 0;
      for ( char c : message.toCharArray() ) {
	      if ( i == keyList.length ) {
		      i = 0;
	      }
	      if ( c == 32 ) {
		      result += ( char ) ( c );
	      } else {
		      result += cipherTable [c - 65] [keyList[i] - 65];
	      }
	      i++;
      }
      return result;
   }

   /**
    * Decodes a given message using the created Vigenere Cipher table and the key word/phrase. *
    * @param message The message to be decoded
    * @return The decoded message
    */
   String decode( String message ) {
      String result = "";
      int i = 0;
      for ( char c : message.toCharArray() ) {
	      if ( i == keyList.length ) {
		      i = 0;
	      }
	      if ( c == 32 ) {
		      result += ( char ) ( c );
	      } else {
		     int j = 0;
		    while ( cipherTable[keyList[i] - 65][j] != c ) {
			    j++;
		    }
		    result += ( char ) ( j + 65 );
	      }
	      i++;
      }
      return result;
   }

   // CONSTRUCTORS
   /**
    * Creates a Vigenere Cipher table as a two dimensional array and puts the given key word/phrase into a character array. *
    * @param code The character used to create the Cipher table
    * @param key The key word/phrase to be turned into a char array
    */
   public Prog5Cipher( char code, String key ) {
      
      for ( int i = 0; i < 26; i++ ) {
	      char initial = code;
	      for ( int j = 0; j < 26; j++ ) {
		      while ( initial + i + j  > 90 ) {
			      initial -= 26;
		      }
		      cipherTable[i][j] = ( char ) ( initial + i + j );
	      }
      }
      keyList = key.toCharArray();
   }

   // MAIN (TEST) Method
   /**
    * METHOD DESCRIPTION COMMENT
    * @param args
    */
   public static void main( String[ ] args ) {      
      // Testing only works if using VM argument -ea
     Prog5Cipher self = new Prog5Cipher( 'H', "BABBAGE" );
     assert "PHXXF MQYBPKNJ".equals( self.encode( "HAPPY BIRTHDAY" ) );
     assert "HAPPY BIRTHDAY".equals( self.decode( "PHXXF MQYBPKNJ" ) );
   }
} // END OF CLASS --------------------------------------------------------
