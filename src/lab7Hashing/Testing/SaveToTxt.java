package lab7Hashing.Testing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveToTxt {
    public SaveToTxt(){

    }

    public void save(String filename, ArrayList<ArrayList<Double>> loadFactor,
                     ArrayList<ArrayList<Integer>> collisions,
                     ArrayList<ArrayList<Integer>> hashFunctionEvaluations,
                     ArrayList<ArrayList<Integer>> insertComparisons){

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/lab7Hashing/files/"+filename + ".txt"));

            writer.write("LOAD FACTOR\n");
            writer.write(" ;0.1;0.2;0.5;0.9\n");

            for (int i = 0; i < loadFactor.get(0).size(); i++) {
                writer.write(i+";");
                for (int j = 0; j < loadFactor.size(); j++) {
                    if(j==loadFactor.size()-1){
                        writer.write(loadFactor.get(j).get(i).toString().replace(".", ",")+"\n");
                    }else{
                        writer.write(loadFactor.get(j).get(i).toString().replace(".", ",")+ ";");
                    }
                }

            }

            writer.write("\nCOLLISIONS\n");
            writer.write(" ;0.1;0.2;0.5;0.9\n");

            for (int i = 0; i < collisions.get(0).size(); i++) {
                writer.write(i+";");
                for (int j = 0; j < collisions.size(); j++) {
                    if(j==collisions.size()-1){
                        writer.write(collisions.get(j).get(i)+"\n");
                    }else{
                        writer.write(collisions.get(j).get(i)+ ";");
                    }
                }

            }

            writer.write("\nHASH FUNCTION EVALUATIONS\n");
            writer.write(" ;0.1;0.2;0.5;0.9\n");

            for (int i = 0; i < hashFunctionEvaluations.get(0).size(); i++) {
                writer.write(i+";");
                for (int j = 0; j < hashFunctionEvaluations.size(); j++) {
                    if(j==hashFunctionEvaluations.size()-1){
                        writer.write(hashFunctionEvaluations.get(j).get(i)+"\n");
                    }else{
                        writer.write(hashFunctionEvaluations.get(j).get(i)+ ";");
                    }
                }

            }

            writer.write("\nINSERT COMPARISONS\n");
            writer.write(" ;0.1;0.2;0.5;0.9\n");

            for (int i = 0; i < insertComparisons.get(0).size(); i++) {
                writer.write(i+";");
                for (int j = 0; j < insertComparisons.size(); j++) {
                    if(j==insertComparisons.size()-1){
                        writer.write(insertComparisons.get(j).get(i)+"\n");
                    }else{
                        writer.write(insertComparisons.get(j).get(i)+ ";");
                    }
                }

            }

            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
