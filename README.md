# HttpClient

Zadanie rekrutacyjne:
Stwórz aplikację, która będzie:
- Wykorzystywać publiczne API https://newsapi.org, pobierać artykuły w kategorii business, dla kraju Polska
- Zapisywać pobierane artykuły we wskazanym pliku tekstowym zgodnie z poniższym formatem:
title:description:author
title:description:author
…
Informacje dodatkowe:
- Aplikacja nie musi posiadać interfejsu graficznego - może działać w konsoli
- Możesz wykorzystać „czystą" Javę, ale jeśli wolisz, możesz zastosować znane Ci biblioteki lub frameworki, dodatkowym atutem będzie stworzeni testów jednostkowych.

Rozwiązanie:
Aplikacja jest podzielona na pakiety :
-http -> zawiera klasę ApiClient która posiada dwie metody, łączącą się i pobierająca dane z przekazanego linku oraz metoda konwertująca dane w JSON na Obiekty w java (Tutaj wykorzystałem do tego biblioteki gson).
Dodatkowo w pakiecie response znajdują się obiekty javy na które konwertowane są dane z formatu JSON

-pakiet io zawiera klasę interfejs i implementującą go klasę zawierająca metodę do zapisu przekazanej listy obiektów do pliku tekstowego ( tutaj do zapisu plików wykorzystałem bibliotekę OpenCSV)

-pakiet mapper zawiera interfejs oraz implementująca go klasę z metodą mapującą obiekt Article z wszystkimi informacjami pobranymi z API na ArticleOutput który zawiera tylko te dane wymagane w zadania tj. title, description i author.

-pakiet model zawiera tylko klase ArticleOutput

- pakiet app zawiera klasę App która skleja całość czyli pyta o nazwę pliku, pobiera dane korzystając z zaimplementowanych klas, mapuje obiekty i zapisuje je do pliku, dzięki czemu w głównej klasie z metodą Main mamy wywołana tylko metodę "run" z klasy App
