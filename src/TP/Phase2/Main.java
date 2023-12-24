package TP.Phase2;

import TP.models.Departement;
import TP.models.Enseignant;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/systeme-educative";
        String user = "root";
        String mdp = "";
        try {
            Connection cx = DriverManager.getConnection(url, user, mdp);
            System.out.println("Good Connection");

            CreateTableEnseignant(cx);

            CreateTableDepartement(cx);

            InsertTableEns(new Enseignant(2,"miray","lina","miraylina@gmail.com","1er annee",new Departement("mip")),cx);

            InsertTableDept(new Departement(5,"gegm"),cx);

            UpdateEnseignant(new Enseignant(2,"chaa","chai","chaachai@gmail.com","2eme annee",new Departement("mip")),cx);

            UpdateDepartement(new Departement(5,"bcg"),cx);

            ArrayList<Enseignant> allEnseignant = SelectEnseignant(cx);
             for(Enseignant ens: allEnseignant){
                System.out.println("ID:"+ ens.getId());
                System.out.println("Nom:"+ ens.getNom());
                System.out.println("Prenom:"+ ens.getPrenom());
                System.out.println("Email:"+ ens.getEmail());
                System.out.println("Grade:"+ ens.getGrade());
                Departement dep = ens.getDep();
                if (dep!=null){
                    System.out.println("Departement:" + dep.getIntitule());
                } else {
                    System.out.println("l'enseignant n'est pas un chef de departement");
                }
                System.out.println("--------------------------------------------");
            }

            ArrayList<Departement> allDepartement = SelectDepartement(cx);
             for(Departement dept: allDepartement){
               System.out.println("ID:"+ dept.getId());
               System.out.println("Nom:"+ dept.getIntitule());

            }

             DeleteEnseignant(1,cx);
             DeleteDepartement(1,cx);

        } catch (SQLException e) {
            System.out.println("Bad connection");
            e.printStackTrace();
        }
    }

   public static void CreateTableEnseignant(Connection cx) throws SQLException {
       String sql="CREATE TABLE IF NOT EXISTS enseignant(\n "+
                 "id INT PRIMARY KEY AUTO_INCREMENT, \n"+
                 "nom VARCHAR(250),\n"+
                 "prenom VARCHAR(250),\n"+
                 "email VARCHAR(250),\n"+
                 "grade VARCHAR(250),\n"+
                 "dep VARCHAR(250),\n"+
                "FOREIGN KEY (dep) REFERENCES Departement(intitule)\n"+ ");";
       Statement st=cx.createStatement();
        st.execute(sql);
       System.out.println("Un nouveau tableau a été créé avec succès");
    }
    public static void InsertTableEns(Enseignant enseignant, Connection cx) throws SQLException {
        String sql = "INSERT INTO enseignant(id,nom,prenom,email,grade,dep) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = cx.prepareStatement(sql);
        ps.setInt(1,enseignant.getId());
        ps.setString(2,enseignant.getNom());
        ps.setString(3,enseignant.getPrenom());
        ps.setString(4,enseignant.getEmail());
        ps.setString(5,enseignant.getGrade());
        ps.setString(6,enseignant.getDep().getIntitule());

        int rowsInserted = ps.executeUpdate();
        if (rowsInserted>0) {
           System.out.println("Un nouveau enseignant a été inséré avec succés");
       }
      }

    public static ArrayList<Enseignant> SelectEnseignant(Connection cx) throws SQLException {
      String sql ="SELECT * FROM enseignant";
      ArrayList<Enseignant> enseignants = new ArrayList<>();
       Statement st = cx.createStatement();
       ResultSet rslt = st.executeQuery(sql);
       while (rslt.next()){
       Enseignant ens = new Enseignant();
       ens.setId(rslt.getInt("id"));
       ens.setNom(rslt.getString("nom"));
       ens.setPrenom(rslt.getString("prenom"));
       ens.setEmail(rslt.getString("email"));
       ens.setGrade(rslt.getString("grade"));
       Departement dept = new Departement();
       dept.setIntitule(rslt.getString("dep"));
       ens.setDep(dept);
       enseignants.add(ens);
     }

        return enseignants;
    }

    public static void UpdateEnseignant(Enseignant enseignant, Connection cx) throws SQLException {
        String sql = "UPDATE enseignant SET nom=?, prenom=?, email=?, grade=?, dep=? WHERE id=? ";

        PreparedStatement ps = cx.prepareStatement(sql);

        ps.setString(1, enseignant.getNom());
        ps.setString(2, enseignant.getPrenom());
        ps.setString(3, enseignant.getEmail());
        ps.setString(4, enseignant.getGrade());
        ps.setString(5, enseignant.getDep().getIntitule());
        ps.setInt(6, enseignant.getId());

        int rowsInserted = ps.executeUpdate();
         if (rowsInserted>0) {
            System.out.println("la table enseignant a été mise à jour ");
         } else{
            System.out.println("Aucun mise à jour effectuée . Vérifiez l'ID de l'enseignant.");
         }
       }
         public static void DeleteEnseignant(int id, Connection cx) throws SQLException {
          String query="DELETE FROM enseignant WHERE id=?";
          PreparedStatement ps = cx.prepareStatement(query);
          ps.setInt(1,id);
          ps.execute();
          System.out.println("Delete de enseignant de l'id:"+id+", est fait avec succés");
         }

    public static void CreateTableDepartement(Connection cx) throws SQLException {
       String sql="CREATE TABLE IF NOT EXISTS departement(\n "+
                "id INT PRIMARY KEY AUTO_INCREMENT, \n"+
                "intitule VARCHAR(250)\n"+
                ");";
        Statement st=cx.createStatement();
        st.execute(sql);
        System.out.println("Un nouveau tableau a été créé avec succès");
    }
    public static void InsertTableDept(Departement departement, Connection cx) throws SQLException {
        String sql = "INSERT INTO departement (id,intitule) VALUES(?,?)";
         PreparedStatement ps = cx.prepareStatement(sql);
         ps.setInt(1,departement.getId());
         ps.setString(2,departement.getIntitule());

         int rowsInserted = ps.executeUpdate();
         if (rowsInserted>0) {
             System.out.println("Un nouveau departement a été inséré avec succés");
         }
     }
    public static ArrayList<Departement> SelectDepartement(Connection cx) throws SQLException {
         String sql ="SELECT * FROM departement";
          ArrayList<Departement> departements = new ArrayList<>();
          Statement st = cx.createStatement();
          ResultSet rslt = st.executeQuery(sql);
          while (rslt.next()){
          Departement dept = new Departement();
          dept.setId(rslt.getInt("id"));
          dept.setIntitule(rslt.getString("intitule"));
          departements.add(dept);
           }

         return departements;
         }


    public static void UpdateDepartement(Departement dept, Connection cx) throws SQLException {
        String sql= "UPDATE departement SET intitule=? WHERE id=? ";
         PreparedStatement ps = cx.prepareStatement(sql);
         ps.setString(1,dept.getIntitule());
         ps.setInt(2,dept.getId());

         int rowsInserted = ps.executeUpdate();
         if (rowsInserted>0) {
           System.out.println("la table enseignant a été mise à jour ");
          } else{
            System.out.println("Aucun mise à jour effectuée . Vérifiez l'ID de l'enseignant.");
         }
        }

    public static void DeleteDepartement(int id, Connection cx) throws SQLException {
        String query="DELETE FROM departement WHERE id=?";
         PreparedStatement ps = cx.prepareStatement(query);
          ps.setInt(1,id);
          ps.execute();
          System.out.println("supprimer le departement de l'id:"+id+", est fait avec succés");
         }
}
