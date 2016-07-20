/**
 * Interface of Manner class
 * Main functions:
 * - Model what the diferent manners(classes) might be able to do
 * 
 */

public interface IManner{
    
    public Int Ability1(); 
    //Damage ability
    
    public void Ability2(Attribute attribute);
    //Buff ability
    
    public Int Ability3();
    //Damage ability
    
    public Int Ability4();
    //Damage ability
    
    public String getManner();
    //Returns the type of manner of said character
    

}