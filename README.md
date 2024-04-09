# SchulHardwareManagement-Projekt

## Projektübersicht
Das SchulHardwareManagement-System ist eine umfassende Webanwendung, die für die Verwaltung von Hardware-Ressourcen innerhalb von Bildungseinrichtungen konzipiert wurde. Es ermöglicht das Verfolgen, Ausleihen und Rückgeben von Gegenständen, um eine effiziente Nutzung der Ressourcen zu gewährleisten. Die Anwendung bietet eine benutzerfreundliche Schnittstelle für Schüler und Lehrer, mit Authentifizierungsmechanismen, die einen sicheren Zugriff auf das System sicherstellen.

## Funktionen
- **Benutzerauthentifizierung**: Sichere Anmelde- und Abmeldefunktionalität.
- **Verwaltung des Hardware-Katalogs**: Hinzufügen, Aktualisieren, Löschen und Auflisten von Hardware-Gegenständen.
- **Ausleihsystem**: Benutzer können Gegenstände ausleihen, indem sie diese ihrem Warenkorb hinzufügen, und Ausleihvorgänge verwalten.
- **Benutzerverwaltung**: Suchen von Benutzern per E-Mail oder Chip-ID zum Ausleihen von Gegenständen.
- **Rollenbasierte Zugriffskontrolle**: Unterschiedliche Zugriffsebenen für Schüler und Lehrer.
- **RFID-Integration**: Verfolgen von Benutzerinteraktionen mit Hardware-Gegenständen über RFID-Chip-ID.
- **Echtzeit-Statusaktualisierungen**: Aktualisierungen des zuletzt gescannten Benutzers und des Status von Gegenständen.
- **Responsive Design**: Zugänglich auf verschiedenen Geräten mit einer benutzerfreundlichen Schnittstelle.

## Verwendete Technologien
- **Spring Boot**: Für die Erstellung des RESTful-Backends.
- **Spring Security**: Für Authentifizierung und Autorisierung.
- **Hibernate und JPA**: Für ORM und Datenbankinteraktionen.
- **MySQL**: Als relationale Datenbank.
- **jSerialComm**: Für die serielle Kommunikation mit RFID-Lesegeräten.
- **Bootstrap und jQuery**: Für die Frontend-Entwicklung.

## Ausführung
1. **Einrichtung der Umgebung**:
   - Stellen Sie sicher, dass Java JDK 11 oder später installiert ist.
   - Installieren Sie MySQL und importieren Sie die Datenbank namens `schul_hardware_management`.
   - Installieren Sie Maven zur Verwaltung von Abhängigkeiten.

2. **Konfiguration**:
   - Aktualisieren Sie `src/main/resources/application.properties` mit Ihren Datenbankanmeldedaten.
   - Konfigurieren Sie den COM-Port in `SerialPortReader.java`, wenn Sie die RFID-Funktionalität nutzen.

3. **Bauen und Ausführen**:
   - Navigieren Sie im Terminal zum Stammverzeichnis des Projekts.
   - Führen Sie `mvn spring-boot:run` aus, um die Anwendung zu starten.
   - Die Anwendung ist verfügbar unter `http://localhost:8080`.

## Nutzung
- **Anmeldung**: Greifen Sie auf das System mit Ihren Anmeldedaten zu. Verschiedene Funktionen stehen je nach Benutzerrolle zur Verfügung.
- **Verwaltung von Hardware-Gegenständen**: Navigieren Sie zu `Artikel hinzufügen`, um neue Hardware hinzuzufügen, oder verwenden Sie die Haupttabelle, um vorhandene Gegenstände zu aktualisieren oder zu löschen.
- **Ausleihen**: Wählen Sie Gegenstände aus der Liste und fügen Sie diese Ihrem Warenkorb hinzu. Schließen Sie den Ausleihvorgang ab, indem Sie zur Kasse gehen.
- **Rückgabe von Gegenständen**: Greifen Sie auf den `Warenkorb` zu, um ausgeliehene Gegenstände anzusehen und zurückzugeben.

## Entwicklung und Beiträge
- Das Projekt steht für Entwicklung und Beiträge offen. Bitte folgen Sie den Standard-Codierungskonventionen und reichen Sie Pull Requests zur Überprüfung ein.
- Für neue Funktionen oder Fehlerbehebungen erstellen Sie ein Issue, bevor Sie mit der Implementierung fortfahren.

## Kontakt
- Für Unterstützung oder Anfragen kontaktieren Sie bitte die Projektverantwortlichen unter [it3z.team3@itech.de](mailto:it3z.team3@itech.de).
