# codility-java
Codility Developer Training – Java megoldások JUnit tesztekkel

# Codility felkészülés

## Általános szokások a teszten
- Kódolás előtt: assumptions → N tartománya ÉS az értékek tartománya külön!
- Szélső esetek felírása kódolás előtt, felvenni őket a test-input.txt-be.
- Először működő (akár brute force) megoldás, utána optimalizálás.
- Beküldés előtt: debug println törlése, Run code a takarítás után is.
- Két egymás utáni ciklus O(N); egymásba ágyazott O(N²).

## 0. Egymenetes bejárás számlálóval és futó maximummal

**Ötlet:** egyszer végigmegyek a sorozaton. Egy számlálóval mérem az aktuális
szakasz hosszát, egy változóban tartom az eddigi legjobbat. Amikor a szakasz
lezárul, összevetem a maximummal, és nullázom a számlálót.

**Mikor:** "leghosszabb szakasz", "leghosszabb egyforma sorozat",
"legnagyobb távolság két elem között".

**Csapdák:**
- char-t `'1'`-gyel hasonlítok, nem `1`-gyel
- a számlálót MINDEN lezárásnál nullázom, nem csak új maximumnál
- a lezáratlan szakasz (pl. záró nullák) nem számít → csak lezáráskor frissítek
- milyen feltételezésre épül a kód? (pl. toBinaryString nem ír vezető nullát)

**Feladatok:** BinaryGap (Codility, Easy, 100%)

## 1. Számláló tömb / HashMap

**Ötlet:** egy menetben megszámolom, hányszor fordul elő minden érték;
utána minden kérdés O(1). Az érték lesz az index, a rekesz értéke a darabszám.

**Mikor:** "hányszor fordul elő", "előfordul-e", "hiányzik-e", "leggyakoribb".

**Tömb vagy map:** ha az értékek kis, ismert tartományban vannak (1..N) → int[N+1];
negatív / óriási értékek → HashMap, vagy kiszűrni, ami úgyis közömbös.

**Csapdák:**
- tömbméret N+1 (index = érték, a 0. rekesz kimarad)
- értékek tartománya > N → szűrni kell, különben ArrayIndexOutOfBounds
- `count[x] = + 1` NEM növelés → `count[x]++`
- leggyakoribb: két változó kell (maxCount ÉS a szám); döntetlenkor
  növekvő bejárás + szigorú `>` → a legkisebb nyer
- map.get() null-t ad, ha nincs kulcs → getOrDefault

**Feladatok:** RepeatedValues, MostFrequent, MissingInteger (Codility, Medium, 100%)

## Java API puska
- Map: put, get (null!), getOrDefault, merge(k, 1, Integer::sum), containsKey
- Set: add (false, ha már benne volt), contains
- Arrays: sort, fill, toString (debug)
- String: length(), charAt(i), toCharArray(); tömb: length (zárójel nélkül)
- Integer.toBinaryString, Integer.MAX_VALUE (≈2,1 milliárd → overflow: long)
