````mermaid
erDiagram
    Artwork }o--o{ Character : contains
    Artwork {
        int ID PK
        string title
        string filePath
        string medium
        string description
        Date date
    }
    Character {
        int ID PK
        string name
        string bio
    }
    
````