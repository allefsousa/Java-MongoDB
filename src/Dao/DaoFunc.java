/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.CadastroFunc;
import View.Cadastro;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.sql.ResultSet;

/**
 *
 * @author Allef
 */
public class DaoFunc {
    // conectando ao mongo, como esta sem parametros
        //se conecta ao mongo local por default 
        MongoClient mongoClient = new MongoClient();
        
        DB db = (DB) mongoClient.getDB("JavaMongoDB");
        DBCollection collection = db.getCollection("funcionario");
        public void put(Model.CadastroFunc c){
             BasicDBObject doc = new BasicDBObject();
             doc.put("id", c.getId());
             doc.put("Nome", c.getNome());
             doc.put("Sobrenome",c.getSobrenome());
             doc.put("CPF", c.getCpf());
             doc.put("Idade", c.getIdade());
             doc.put("Salario", c.getSalario());
             collection.insert(doc);
        }
        public DBCursor  get(){
        DBCollection col = db.getCollection("funcionario");
             DBCursor cursor = col.find();
             return cursor;
             
        }
        public void Atualizar(){
        
        }
        public void Deletar(int id){
              BasicDBObject doc = new BasicDBObject();
              doc.put("id", id);
              collection.remove(doc);
        }
       
        
        
}
