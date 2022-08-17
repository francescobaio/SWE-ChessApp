package domain_model;

public class EloTable {
	
	
	public static final float[][] eloTable = {
			
			{0,0.5f,0.5f},
			{4,0.51f,0.49f},
			{11,0.52f,0.48f},
			{18,0.53f,0.47f},
			{26,0.54f,0.46f},
			{33,0.55f,0.45f},
			{40,0.56f,0.44f},
			{47,0.57f,0.43f},
			{54,0.58f,0.42f},
			{62,0.59f,0.41f},
			{69,0.60f,0.40f},
			{77,0.61f,0.39f},
			{84,0.62f,0.38f},
			{92,0.63f,0.37f},
			{99,0.64f,0.36f},
			{107,0.65f,0.35f},
			{114,0.66f,0.34f},
			{122,0.67f,0.33f},
			{130,0.68f,0.32f},
			{138,0.69f,0.31f},
			{146,0.70f,0.30f},
			{154,0.71f,0.29f},
			{163,0.72f,0.28f},
			{171,0.73f,0.27f},
			{180,0.74f,0.26f},
			{189,0.75f,0.25f},
			{198,0.76f,0.24f},
			{207,0.77f,0.23f},
			{216,0.78f,0.22f},
			{226,0.79f,0.21f},
			{236,0.80f,0.20f},
			{246,0.81f,0.19f},
			{257,0.82f,0.18f},
			{268,0.83f,0.17f},
			{279,0.84f,0.16f},
			{291,0.85f,0.15f},
			{303,0.86f,0.14f},
			{316,0.87f,0.13f},
			{329,0.88f,0.12f},
			{345,0.89f,0.11f},
			{358,0.90f,0.10f},
			{375,0.91f,0.09f},
			{392,0.92f,0.08f},
			{412,0.93f,0.07f},
			{433,0.94f,0.06f},
			{457,0.95f,0.05f},
			{485,0.96f,0.04f},
			{518,0.97f,0.03f},
			{560,0.98f,0.02f},
			{620,0.99f,0.01f},
			{736,1,0},
			{2800,1,0}
			
			
	};
	
	
	private EloTable() {}
	
	
	public static float getVariation(int playerElo,int opponentElo) {
		
		int diff = playerElo - opponentElo;
		boolean isNegative;
		if(diff >= 0) {
			isNegative = false;
		}else {
			isNegative = true;
			diff *= -1;
		}
		
		int index = 0;
		
		while(diff >= eloTable[index][0] ) {
			index++;
		}
		
		if(isNegative) {
			return eloTable[index-1][2];
			
		}else {
			return eloTable[index-1][1];
		}
	}
		
}
