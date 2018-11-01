-- 2007 Dirk W. Hoffmann
-- Hochschule Karlsruhe
--
-- Testbench for the "parity" design
-- ----------------------------------------------------

entity test_parity is
    PORT ( y_out : OUT bit);
end;

architecture only of test_parity is

SIGNAL i4 : bit := '0';
SIGNAL i3 : bit := '0';
SIGNAL i2 : bit := '0';
SIGNAL i1 : bit := '0';

COMPONENT parity
      port(in_4,in_3,in_2,in_1 : in bit;
                            y : out bit);
END COMPONENT ;

for dut : parity use entity work.parity(KNF)
    port map (x4=>in_4, x3=>in_3, x2=>in_2, x1=>in_1, y=>y);
   
begin

dut : parity 
   port map (
   in_4 => i4,
   in_3 => i3,
   in_2 => i2,
   in_1 => i1,
   y => y_out);

stimulus : process
   begin
   i4<='0'; i3<='0'; i2<='0'; i1<='0';
   wait for 1 ns;
   i4<='0'; i3<='0'; i2<='0'; i1<='1';
   wait for 1 ns;
   i4<='0'; i3<='0'; i2<='1'; i1<='0';
   wait for 1 ns;
   i4<='0'; i3<='0'; i2<='1'; i1<='1';
   wait for 1 ns;
   i4<='0'; i3<='1'; i2<='0'; i1<='0';
   wait for 1 ns;
   i4<='0'; i3<='1'; i2<='0'; i1<='1';
   wait for 1 ns;
   i4<='0'; i3<='1'; i2<='1'; i1<='0';
   wait for 1 ns;
   i4<='0'; i3<='1'; i2<='1'; i1<='1';
   wait for 1 ns;
   i4<='1'; i3<='0'; i2<='0'; i1<='0';
   wait for 1 ns;
   i4<='1'; i3<='0'; i2<='0'; i1<='1';
   wait for 1 ns;
   i4<='1'; i3<='0'; i2<='1'; i1<='0';
   wait for 1 ns;
   i4<='1'; i3<='0'; i2<='1'; i1<='1';
   wait for 1 ns;
   i4<='1'; i3<='1'; i2<='0'; i1<='0';
   wait for 1 ns;
   i4<='1'; i3<='1'; i2<='0'; i1<='1';
   wait for 1 ns;
   i4<='1'; i3<='1'; i2<='1'; i1<='0';
   wait for 1 ns;
   i4<='1'; i3<='1'; i2<='1'; i1<='1';
   wait for 1 ns;


end process stimulus;

end only;

--end
