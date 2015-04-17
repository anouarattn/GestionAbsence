GestionAbsence
==============

## Technologies Utilisées ##

- jboss 7.1.1-final
- jsf 2.1(mojorra 2.1.15)
- primefaces 5.0
- joda time 2.7
- arquillian 1.1.6
- apache maven 3.2.3
- CDI 1.0(weld implementation)


## prérequis de deployement ##

- Un serveur Jboss 7.1.1 démarré
- une base de données avec le nom projetAbsenceTest et le schema suivant(lien)
- La DataSource suivante
```xml 
 <datasource jta="true" jndi-name="java:/MySqlDS2" pool-name="MySqlDS_Pool2" enabled="true">
                    <connection-url>jdbc:mysql://localhost:3306/projetAbsenceTest</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>root</user-name>
                    </security>
 </datasource>
```
## deployement ##

- dans le dossier parent  
``` mvn install ```

## Notes ##

Dans ce projet, On utilise les règles émis par RFC 2119(https://www.ietf.org/rfc/rfc2119.txt) pour spécifier les exigences fonctionnelles et techniques(Voir la Wiki)
