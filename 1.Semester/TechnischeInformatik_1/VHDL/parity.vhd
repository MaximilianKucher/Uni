-- Parity-Generator
--
-- 2007 Dirk W. Hoffmann
-- Hochschule Karlsruhe
-- ----------------------------------------------------
entity Not1 is
   port(X : in bit; Y : out bit);
end;

architecture Only of Not1 is
begin
    Y <= not X;
end;
-- ----------------------------------------------------       
entity And4 is
   port(X4, X3, X2, X1 : in bit; 
                    Y : out bit);
end;

architecture Only of And4 is
begin
    Y <= X4 and X3 and X2 and X1;
end;
-- ----------------------------------------------------	 
entity And8 is
   port(X8, X7, X6, X5, X4, X3, X2, X1 : in bit; 
                    Y : out bit);
end;

architecture Only of And8 is
begin
    Y <= X8 and X7 and X6 and X5 and X4 and X3 and X2 and X1;
end;
-- ----------------------------------------------------	
entity Or4 is
   port(X4, X3, X2, X1 : in bit;
                                     Y : out bit);
end;

architecture Only of Or4 is
begin
    Y <= X4 or X3 or X2 or X1;
end;
-- ----------------------------------------------------
entity Or8 is
   port(X8, X7, X6, X5, X4, X3, X2, X1 : in bit;
                                     Y : out bit);
end;

architecture Only of Or8 is
begin
    Y <= X8 or X7 or X6 or X5 or X4 or X3 or X2 or X1;
end;
-- ----------------------------------------------------
entity Parity is
   port(X4,X3,X2,X1 : in bit;
                  Y : out bit);
end;

architecture Behavioral of Parity is
begin
	with bit_vector'(X4,X3,X2,X1) 
	  select
	  Y <=	'0' when "0000",
		    '1' when "0001",
		    '1' when "0010",
		    '0' when "0011",
 		    '1' when "0100",
	 	    '0' when "0101",
		    '0' when "0110",
		    '1' when "0111",
		    '1' when "1000",
		    '0' when "1001",
		    '0' when "1010",
		    '1' when "1011",
		    '0' when "1100",
		    '1' when "1101",
		    '1' when "1110",
		    '0' when "1111";
end Behavioral;
-- ----------------------------------------------------
architecture Structural of Parity is

   signal N1, N2, N3, N4 : Bit;
   signal S1, S2, S3, S4, S5, S6, S7, S8 : Bit;
   
   component Not1
      port(X : in bit; Y : out bit);
   end component;
   component and4
      port(X4, X3, X2, X1 : in bit;
             Y:out bit);
   end component;
   component or8
      port(X8,X7,X6,X5,X4,X3,X2,X1 : in bit;
           Y : out bit);
   end component;
   
begin
   Inv1 : Not1 port map (X1,N1);
   Inv2 : Not1 port map (X2,N2);
   Inv3 : Not1 port map (X3,N3);
   Inv4 : Not1 port map (X4,N4);
   
   Minterm1 : And4 port map (N4,X3,X2,X1,S1);
   Minterm2 : And4 port map (X4,N3,X2,X1,S2);
   Minterm3 : And4 port map (X4,X3,N2,X1,S3);
   Minterm4 : And4 port map (X4,X3,X2,N1,S4);
   Minterm5 : And4 port map (N4,N3,N2,X1,S5);
   Minterm6 : And4 port map (N4,N3,X2,N1,S6);
   Minterm7 : And4 port map (N4,X3,N2,N1,S7);
   Minterm8 : And4 port map (X4,N3,N2,N1,S8);
   
   Final : or8 port map(S8,S7,S6,S5,S4,S3,S2,S1,Y);

end Structural;
-- ----------------------------------------------------
architecture KNF of Parity is

   signal N1, N2, N3, N4 : Bit;
   signal S1, S2, S3, S4, S5, S6, S7, S8 : Bit;

   component Not1
      port(X : in bit; Y : out bit);
   end component;
   component or4
      port(X4, X3, X2, X1 : in bit;
             Y:out bit);
   end component;
   component And8
      port(X8,X7,X6,X5,X4,X3,X2,X1 : in bit;
           Y : out bit);
   end component;

begin
   Inv1 : Not1 port map (X1,N1);
   Inv2 : Not1 port map (X2,N2);
   Inv3 : Not1 port map (X3,N3);
   Inv4 : Not1 port map (X4,N4);

   Maxterm1 : or4 port map (X4,X3,X2,X1,S1);
   Maxterm2 : or4 port map (N4,N3,X2,X1,S2);
   Maxterm3 : or4 port map (X4,N3,X2,N1,S3);
   Maxterm4 : or4 port map (X4,N3,N2,X1,S4);
   Maxterm5 : or4 port map (N4,X3,X2,N1,S5);
   Maxterm6 : or4 port map (N4,X3,N2,X1,S6);
   Maxterm7 : or4 port map (X4,X3,N2,N1,S7);
   Maxterm8 : or4 port map (N4,N3,N2,N1,S8);
   
   Final : And8 port map(S8,S7,S6,S5,S4,S3,S2,S1,Y);

end KNF;


