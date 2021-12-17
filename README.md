# TP3_ISO_Junit
Dans le cadre du développement d'une application, quelle qu'elle soit, les tests sont indispensables, et prennent une part non négligeable du développement. Il en existe plusieurs types : unitaires, intégration, fonctionnels, qualification, etc. Aujourd'hui, la plupart sont automatisés, ce qui permet un gain de temps substantiel, ainsi qu'une plus grande fiabilité.

JUnit est un framework open source pour le développement et l'exécution de tests unitaires automatisables. Le principal intérêt est de s'assurer que le code répond toujours aux
besoins même après d'éventuelles modifications. Plus généralement, ce type de tests est appelé tests unitaires de non-régression.

Dans ce TP, nous allons nous familiariser avec Selenium avec Junit 5. 

L’objectif est d’automatiser le test suivant :

 - Connectez-vous sur l’url https://todomvc.com/
 - Cliquez sur le lien Backbone.js
 - Ajouter plusieurs actions exemples ( Meet a Friend , Buy Meat , clean the car ... )
 - Cochez une ou plusieurs actions
 - Exploitez la méthode ExpectedConditions.textToBePresentInElement afin de comparer le champ x item(s) left par le résultat attendu
 - Exploitez l’annotation @ParameterizedTest afin d’effectuer des tests avec plusieurs technologies dans le site https://todomvc.com/
 - Ajoutez les dependencies appropriés afin d’afficher les rapports Junit.
