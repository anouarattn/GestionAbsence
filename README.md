GestionAbsence
==============

## Technologies Utilisées ##

- jboss 7.1.1-final
- jsf 2.1(mojorra 2.1.15)
- primefaces 5.2
- omnifaces 2
- bean validation 1.0 (hibernate validator 4.2)
- joda time 1.6.2(module jboss as7)
- arquillian 1.1.6
- apache maven 3.2.3
- CDI 1.0(weld implementation)
- Selenium 2.45.0


## prérequis de deployement ##

- Un serveur Jboss 7.1.1 démarré
- une base de données avec le nom projetAbsenceTest

## deployement ##

- dans le dossier parent  
``` mvn install ```

## Notes ##

Dans ce projet, On utilise les règles émis par RFC 2119(https://www.ietf.org/rfc/rfc2119.txt) pour spécifier les exigences fonctionnelles et techniques(Voir la Wiki)
