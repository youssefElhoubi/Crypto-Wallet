# 🚀 Projet : Crypto Wallet Simulator

## 📌 Contexte du projet
Dans l'écosystème des **cryptomonnaies**, chaque transaction nécessite des **frais** pour être validée par le réseau.  
Ces frais varient selon la congestion du réseau et l'urgence souhaitée.  

🎯 **Mission :** Développer une **application console en Java 8** qui simule un wallet crypto avec **mempool** et aide les utilisateurs à optimiser leurs frais de transaction.

---

## 🔑 Concepts Blockchain Essentiels
- 💸 **Transaction** : Transfert de cryptomonnaie d'une adresse à une autre  
- 💰 **Transaction fees** : Frais payés aux mineurs (priorité ↑ si fees ↑)  
- ⛏️ **Mineurs** : Valident les transactions en échange de fees  
- 👛 **Wallet** : Gère vos adresses et transactions  
- 📥 **Mempool** : File d’attente des transactions en attente de validation  
- ⚡ **Priorité** :  
  - 🟢 **ÉCONOMIQUE** → lent  
  - 🟡 **STANDARD** → moyen  
  - 🔴 **RAPIDE** → rapide  

---

## 🏗️ Relations Métier entre les Entités
- 🔗 Une transaction est liée à un **wallet spécifique** (Bitcoin ou Ethereum)  
- 🆔 Chaque transaction possède :  
  - ID unique  
  - Adresse source & destination (formats BTC/ETH)  
  - Montant, date, frais sélectionnés  
- 📊 Transactions : **PENDING**, **CONFIRMED**, **REJECTED**  
- 👛 Un wallet peut contenir plusieurs transactions  
- ⏳ Le mempool trie selon les frais (les + élevés passent en premier)  
- ⚙️ Logique de calcul :  
  - **Bitcoin** → taille (bytes) × satoshi/byte  
  - **Ethereum** → gas limit × gas price  

---

## 🏛️ Architecture de l’Application
- 🎨 **Couche de présentation (UI/Menu)**  
- 🧠 **Couche métier**  
- 🗄️ **Couche de données (Repository Pattern)**  
- 🛠️ **Couche utilitaire**  
- ➕ Autres couches pertinentes  

---

## 🔄 Algorithme Principal
### Simulateur de **Mempool & Fee Calculator**
- Générer un mempool avec **10–20 transactions aléatoires**  
- Calculer la position de la nouvelle transaction selon ses frais  
- ⏱️ Estimer le temps : `position × 10 minutes`  

---

## 📜 Menu Interactif
Fonctionnalités principales :  
1. 👛 **Créer un wallet crypto**  
2. ➕ **Créer une nouvelle transaction**  
3. 📊 **Calculer la position dans le mempool et temps estimé**  
4. ⚖️ **Comparer les 3 niveaux de frais (fee levels)**  
5. 📥 **Consulter l’état actuel du mempool**  

---

## 🔎 Explication des Fonctionnalités
### 1️⃣ Créer un Wallet
- Choisir : **Bitcoin** ou **Ethereum**  
- Générer une adresse unique  
- Solde initial = **0**  
- Attribuer un ID unique  

### 2️⃣ Créer une Transaction
- Entrer source, destination, montant  
- Choisir le niveau de frais  
- Valider et calculer les frais selon crypto/priorité  
- Créer avec statut **PENDING**  
- Générer un UUID unique  

### 3️⃣ Voir la Position dans le Mempool
- Afficher : `Votre transaction est en position X sur Y`  
- Estimer le temps d’attente  

### 4️⃣ Comparer les 3 Niveaux de Frais
- Afficher tableau comparatif **coût vs rapidité**  

### 5️⃣ Consulter l’État du Mempool
- Générer des transactions fictives  
- Afficher la liste avec frais payés par chacun  

---

## ⚙️ Spécifications Techniques
- 📚 Collections : `ArrayList`, `HashMap`  
- 🏷️ **Enums obligatoires** : priorités, statuts, types  
- 🕒 **Java Time API** pour dates & durées  
- 🛡️ **Exceptions** avec `try-catch`  
- 💾 Persistance : **PostgreSQL via JDBC**  
- ✅ Validations : montants positifs, adresses valides, fee levels corrects  
- 📝 Logging : `java.util.logging`, **SLF4J** ou **Logback**  
- 🔎 **Stream API** : `map`, `filter`, `reduce`, `Optional`  
- 🐞 Techniques de débogage maîtrisées  

---

## 📂 Gestion de Projet
- 🌿 Git avec branches multiples  
- 🗂️ JIRA pour planification  
- 🖥️ IDE au choix : **Eclipse, VSCode, IntelliJ**  
- 🔌 Plugins : **SonarLint, UML generator**  
- ⌨️ Raccourcis essentiels : Run, Debug, Search, Refactoring, Go To Declaration  

---

## 🎁 Bonus
- ✅ **Tests unitaires** avec JUnit (2 min.)  
- 📤 Export CSV des transactions  
- 🐳 **Dockerisation** avec Dockerfile  

---

## 📏 Exigences
- ☕ **Java 8 uniquement**  
- ❌ Maven interdit → utiliser uniquement `javac` et `java`  
- 🧩 Principes **SOLID**  
- 🏗️ Design Patterns : **Singleton, Repository Pattern**  
- 📑 Interfaces & héritage obligatoires  

### ⚠️ Anti-patterns à éviter
- ❌ God Class  
- ❌ Couplage fort  
- ❌ Mélanger logique métier et affichage  
- ❌ Violation de l’encapsulation  
- ❌ Code dupliqué  
- ❌ Magic numbers  
- ❌ Constantes en String/int au lieu d’Enums  

---

## 🎓 Modalités Pédagogiques
- Projet **individuel**  
- Durée : **7 jours**  
- 🗓️ Début : 22/09/2025  
- ⏳ Deadline : 30/09/2025 (avant minuit)  

---

## 📝 Modalités d’Évaluation
- 🎤 Présentation client & technique  
- 💻 Démonstration des fonctionnalités  
- ❓ Q/A techniques  
- 🔍 Review de code & bonnes pratiques  

---

## 📦 Livrables
🔗 GitHub contenant :  
- 🧾 Code source complet (branches multiples)  
- 📦 Fichier **.jar exécutable**  
- 📐 Diagramme de classes UML  
- 🗄️ Script SQL  
- 📘 **README.md** avec :  
  - Description du projet  
  - Technologies utilisées  
  - Structure du projet  
  - Prérequis & installation  
  - Guide d’utilisation  
  - Captures d’écran  

---

## 🏆 Critères de Performance
- ✅ Développé exclusivement en **Java 8**  
- ✅ Application complète et fonctionnelle  
- ✅ Structure en couches respectée  
- ✅ Code propre, commenté, conventions Java suivies  
- ✅ Logs séparés (`System.out` vs Logger)  
- ✅ Enums utilisés correctement  
- ✅ Historique Git progressif avec branches  
- ✅ README clair et complet  
- ✅ UML fidèle  
- ✅ Respect **SOLID** et Design Patterns  

---