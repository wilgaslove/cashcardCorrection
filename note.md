## Les avantages des tests.
A la fin de votre application, si tout fonctionne bien, c'est que tous les tests marchent.
Les tests constituent des points de repère pour ne pas se perdre dans le code ou pour vite repéré si une eventuellement une érreur est instroduire.

## Le développement piloté par les tests (TDD)
Ecrire des tests avant d'implémenter le code de l'application est le développement piloté par les tests (TDD).

## Base de données intégrée
Une BDD intégrée est une base de données que est intégrée directement dans une application logicielle et fonctionne en mode embarqué. Cela signifie qu'elle est gérée et utilisée par l'application elle-même, sans nécessiter de serveur de base de données externe. Ces BDD sont stackées localement sur le système de l'utilisateur ou dans le répertoire de l'application, et elles sont généralement légères et optimisées pour être rapides et efficaces

## H2 
H2 est l'un des exemples les plus couramment utilisés de BDD intégrées. H2 est une BDD relationnelle écrite en Java qui peut être embarquée dans une application Spring. Elle prend en charge le mode mémoire (les données sont stockées en mémoire et sont perdues lorsque l'application est arrêtée) ainsi que le mode fichier (les données sont stockées dans un fichier su le système de fichiers de l'ordinateur).



## Optional
`Optional` est une classe générique qui peut contenir soit une valeur non nulle, soit aucune valeur (c-à-d vide). L'utilisation de `Optinal` peut rendre le code plus explicite en indiquant clairement qu'une valeur peut être absente et en forçant les développeurs à traiter ce cas.

## Utilisations courantes de optional

1. Eeviter les `NullPointerException`:
En utilisant "optional", nous pouvons éviter les erreurs de pointeur nul en vérifiant d'abord si une valeur est présente avant d'esayer d'y accéder. Par exemple:
```java
Optinal<String> valeurOptionel = // ... obtenir une valeur, peut-être null
if(valeurOptionel.isPresent()){
    String valeur = valeurOptionel.get();// récupère la valeur présente 
    //on fait quelque chose avec la valeur non nulle 
} else {
    // on fait quelque chose en cas d'absence de valeur
}
```

2. Chaînage de méthodes:
Nous pouvons chaînes des méthodes pour éffectuer des opérations sur la valeur si elle est présente, ou ignorer simplement l'opération si la valeur est absente 
```java
Optional<String> valeur = // ... obtenir une valeur peut-être nulle
valeur.ifPresent(v -> System.out.println("Valeur présente:" + v))
```




