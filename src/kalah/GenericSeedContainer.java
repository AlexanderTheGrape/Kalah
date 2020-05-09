package kalah;

abstract class GenericSeedContainer{
    int seeds = 0;

    public int GetSeeds(){
        return seeds;
    }

    public void AddSeeds(int addedSeeds){
        seeds += addedSeeds;
    };
    public void RemoveSeeds(int removedSeeds){
        seeds += removedSeeds;
    };
}