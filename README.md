Was ist der Vorteil einer separaten Test-Klasse?
-
**Trennung von Code und Tests:** Der Anwendungscode bleibt sauber und getrennt von den Tests.

**Wartbarkeit:** Tests können unabhängig vom Anwendungscode angepasst und gewartet werden.

**Wiederverwendbarkeit:** Testklassen sind flexibel und können für verschiedene Testfälle genutzt werden.

**Automatisierung:** Tests lassen sich leicht automatisieren und ausführen, ohne den Hauptcode zu beeinflussen.

Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?
-

Äquivalenzklassen teilen den Eingabebereich in Gruppen mit ähnlichen Eigenschaften auf, sodass pro Klasse nur ein Testfall nötig ist. 
Das reduziert die Anzahl der Tests und stellt gleichzeitig sicher, dass alle relevanten Eingabebereiche abgedeckt werden.

Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar durchführbar?
-

Ein Blackbox-Test mit JUnit auf der Klasse Client ist nicht unmittelbar durchführbar, 
weil der Client auf interne Implementierungen und konkrete Abhängigkeiten wie den GTFactory und GermanTranslator zugreift. 
In einem Blackbox-Test kennt man die interne Struktur der Klasse nicht, und es wäre schwer zu testen, ob die Klasse korrekt funktioniert, 
ohne die genauen Methodenaufrufe und Interaktionen der abhängigen Klassen zu kennen.
