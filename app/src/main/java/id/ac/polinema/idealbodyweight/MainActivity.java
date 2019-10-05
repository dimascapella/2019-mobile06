package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BMIFragment;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;
import id.ac.polinema.idealbodyweight.util.BMIIndex;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener, BrocaIndexFragment.OnFragmentInteractionListener, ResultFragment.OnFragmentInteractionListener, BMIFragment.OnFragmentInteractionListener {

	// Deklarasikan atribut Fragment di sini
	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	private BMIFragment bmiFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		menuFragment = new MenuFragment();
		brocaIndexFragment = new BrocaIndexFragment();
		resultFragment = new ResultFragment();
		bmiFragment = new BMIFragment();
		aboutFragment = AboutFragment.newInstance("Dimas Eka Adinandra");
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, menuFragment).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if(item.getItemId() == R.id.menu_about){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, brocaIndexFragment).addToBackStack(null).commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, bmiFragment).addToBackStack(null).commit();

	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
        resultFragment.setInformation(String.format("Your Ideal weight is %.2f kg", index));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, resultFragment).addToBackStack("brocaIndexFragment").commit();
	}

    @Override
    public void onTryAgainButtonClicked(String tag) {
		if(tag.equals("bmiFragment")){
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, bmiFragment).addToBackStack(null).commit();
		}else if(tag.equals("brocaIndexFragment")){
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, brocaIndexFragment).addToBackStack(null).commit();
		}
    }

	@Override
	public void onCalculateBIMIndexClicked(float index, String type) {
		resultFragment.setInformation(String.format("Your Ideal Body Mass Index %.2f kg", index));
		resultFragment.setSubInfo("Classification " + type);
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, resultFragment).addToBackStack("bmiFragment").commit();
	}
}
