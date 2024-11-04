public class MachineACafe {


	private int montantEnCours = 0;
	private MachineState etatCourant = MachineState.INACTIF;
	private ToucheBoisson boisson = null;

	public void afficherMontant() {
		System.out.println(montantEnCours + " cents disponibles");
	}
	
	public void afficherRetour() {
		System.out.println(montantEnCours + " cents rendus");
	}
	
	public void afficherPasAssez(ToucheBoisson toucheBoisson) {
		System.out.println("Vous n'avez pas introduit un montant suffisant pour un " + toucheBoisson);
		System.out.println("Il manque encore " + (toucheBoisson.getPrix() - montantEnCours) + " cents");
	}

	public void afficherBoisson(ToucheBoisson toucheBoisson) {
		System.out.println("Voici un " + toucheBoisson);
		
	}

	public void entrerMonnaie(Piece piece) {
		etatCourant.entrerMonnaie(piece,this);
	}
	
	public void selectionnerBoisson(ToucheBoisson toucheBoisson) {
		etatCourant.selectionnerBoisson(toucheBoisson , this);
	}

	public void setEtatCourant(MachineState etatCourant) {
		this.etatCourant = etatCourant;
	}

	public void rendreMonnaie() {
		etatCourant.rendreMonnaie(this);
	}

	public enum MachineState {
		INACTIF {
			@Override
			public void rendreMonnaie(MachineACafe mc) {
			}

			@Override
			public void selectionnerBoisson(ToucheBoisson toucheBoisson, MachineACafe mc) {
				mc.afficherPasAssez(toucheBoisson);
				return;
			}

		},
		COLLECTE {
			@Override
			public void selectionnerBoisson(ToucheBoisson toucheBoisson, MachineACafe mc) {
				if (toucheBoisson.getPrix() > mc.montantEnCours) {
					mc.boisson = toucheBoisson;
					mc.afficherPasAssez(mc.boisson);
					mc.boisson = toucheBoisson;
					mc.setEtatCourant(PAS_ASSEZ);
					return;
				}
				mc.montantEnCours -= toucheBoisson.getPrix();
				mc.afficherBoisson(toucheBoisson);
				mc.afficherMontant();
				if (mc.montantEnCours == 0)
					mc.setEtatCourant(INACTIF);
				else
					mc.setEtatCourant(COLLECTE);
			}

		},
		PAS_ASSEZ {
			@Override
			public void selectionnerBoisson(ToucheBoisson toucheBoisson, MachineACafe mc) {
				throw new IllegalStateException("Pas assez pour la boisson");
			}

			@Override
			public void entrerMonnaie(Piece piece, MachineACafe mc) {
				mc.montantEnCours += piece.getValeur();
				mc.afficherMontant();

				if (mc.boisson.getPrix() > mc.montantEnCours) {
					mc.afficherPasAssez(mc.boisson);
				} else {
					mc.montantEnCours -= mc.boisson.getPrix();
					mc.afficherBoisson(mc.boisson);
					mc.boisson = null;
					mc.afficherMontant();
					if (mc.montantEnCours == 0)
						mc.setEtatCourant(INACTIF);
					else
						mc.setEtatCourant(COLLECTE);
				}
			}
		};

		public void rendreMonnaie(MachineACafe mc) {
			mc.afficherRetour();
			mc.montantEnCours = 0;
			mc.boisson = null;
			mc.setEtatCourant(INACTIF);
		}

		abstract public void selectionnerBoisson(ToucheBoisson toucheBoisson, MachineACafe mc);

		public void entrerMonnaie(Piece piece, MachineACafe mc) {
			mc.montantEnCours += piece.getValeur();
			mc.afficherMontant();

			mc.setEtatCourant(COLLECTE);

		}
	}


}
