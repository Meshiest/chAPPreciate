package com.maxkrass.appreciate.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.maxkrass.appreciate.R;
import com.maxkrass.appreciate.views.CheckBoxWidget;

import java.util.Arrays;

public class TeamFragment extends Fragment implements android.view.View.OnClickListener {

	// layouts for teleop and autonomous
	private LinearLayout autoList;
	private LinearLayout teleList;

	// list of matches
	public LinearLayout teleMatchList;

	// textfields
	public EditText teamName, autoPoints, totalPoints, autoComment, teleComment;

	// checkboxes
	public CheckBoxWidget stackedTotesCBW, autoZoneCBW, workedCBW, functionalCBW, coopertitionCBW;

	private ScrollView scrollView;

	public void onClick(View view) {
		if (view instanceof CheckBoxWidget) { // toggle a checkbox if it's clicked
			CheckBoxWidget checkboxwidget = (CheckBoxWidget) view;
			checkboxwidget.setCheckBox(!checkboxwidget.isChecked());
		}
	}

	private void initCBWs(View v) {
		// layout of widgets for autonomous
		autoList = (LinearLayout) v.findViewById(R.id.auto_match_list);

		// a checkbox for autoZone
		autoZoneCBW = new CheckBoxWidget(getActivity());
		autoZoneCBW.setTitleView(getString(R.string.auto_zone_match_label));
		autoZoneCBW.setOnClickListener(this);
		autoList.addView(autoZoneCBW);

		// a checkbox for if autonomous could stack totes
		stackedTotesCBW = new CheckBoxWidget(getActivity());
		stackedTotesCBW.setTitleView(getString(R.string.totes_auto_label));
		stackedTotesCBW.setOnClickListener(this);
		autoList.addView(stackedTotesCBW);

		// a checkbox for whether or not the autonomous worked
		workedCBW = new CheckBoxWidget(getActivity());
		workedCBW.setTitleView(getString(R.string.program_auto_worked));
		workedCBW.setOnClickListener(this);
		autoList.addView(workedCBW);

		// layout of widgets for teleop
		teleList = (LinearLayout) v.findViewById(R.id.tele_list);

		// a checkbox for whether or not the teleop was functional
		functionalCBW = new CheckBoxWidget(getActivity());
		functionalCBW.setTitleView(getString(R.string.functional_tele_match));
		functionalCBW.setOnClickListener(this);
		teleList.addView(functionalCBW);

		// a checkbox for if the robot could do coopertition bins
		coopertitionCBW = new CheckBoxWidget(getActivity());
		coopertitionCBW.setTitleView(getString(R.string.coopertition_tele_match));
		coopertitionCBW.setOnClickListener(this);
		teleList.addView(coopertitionCBW);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mainView = inflater.inflate(R.layout.team_layout, container, false);

		teleMatchList = (LinearLayout) mainView.findViewById(R.id.tele_match_list);

		// storing the elements in objects
		autoPoints = (EditText) mainView.findViewById(R.id.auto_points_field);
		autoComment = (EditText) mainView.findViewById(R.id.auto_comment_field);
		totalPoints = (EditText) mainView.findViewById(R.id.total_score_field);
		teleComment = (EditText) mainView.findViewById(R.id.tele_comment_field);

		scrollView = (ScrollView) mainView.findViewById(R.id.scrollView);
		initCBWs(mainView);

		return mainView;
	}

	// resets the objects
	public void clearFields() {

		// checkboxes are defaulting to false
		autoZoneCBW.setCheckBox(false);
		stackedTotesCBW.setCheckBox(false);
		workedCBW.setCheckBox(false);
		functionalCBW.setCheckBox(false);
		coopertitionCBW.setCheckBox(false);

		// points default to 0
		autoPoints.setText("0");
		totalPoints.setText("0");

		// comments default to empty
		autoComment.setText("");
		teleComment.setText("");

		teleMatchList.removeAllViews();
	}

	/*public void putDataIntoFields(String[] data) {
		String driveTypeArray[];
		String wheelNumArray[];
		String cimNumArray[];
		String wheelTypeArray[];
		String highestStackArray[];
		teamNumber.setText(data[0]);
		driveTypeArray = getResources().getStringArray(R.array.drive_type);
		driveSpinner.setSelection(Arrays.asList(driveTypeArray).indexOf(data[1]));
		wheelNumArray = getResources().getStringArray(R.array.num_wheels);
		wheelNumSpinner.setSelection(Arrays.asList(wheelNumArray).indexOf(data[2]));
		cimNumArray = getResources().getStringArray(R.array.num_cims);
		cimNumSpinner.setSelection(Arrays.asList(cimNumArray).indexOf(data[3]));
		wheelTypeArray = getResources().getStringArray(R.array.wheel_type);
		wheelTypeSpinner.setSelection(Arrays.asList(wheelTypeArray).indexOf(data[4]));
		maxSpeed.setText(data[5]);
		autoZoneAutoCBW.setCheckBox(Boolean.parseBoolean(data[6]));
		totesAutoCBW.setCheckBox(Boolean.parseBoolean(data[7]));
		containersAutoCBW.setCheckBox(Boolean.parseBoolean(data[8]));
		flexibleAutoCBW.setCheckBox(Boolean.parseBoolean(data[9]));
		containersAbilityCBW.setCheckBox(Boolean.parseBoolean(data[11]));
		totesAbilityCBW.setCheckBox(Boolean.parseBoolean(data[12]));
		noodlesAbilityCBW.setCheckBox(Boolean.parseBoolean(data[13]));
		shiftingAbilityCBW.setCheckBox(Boolean.parseBoolean(data[14]));
		coopAbilityCBW.setCheckBox(Boolean.parseBoolean(data[15]));
		wideTeleCBW.setCheckBox(Boolean.parseBoolean(data[16]));
		narrowTeleCBW.setCheckBox(Boolean.parseBoolean(data[17]));
		stepTeleCBW.setCheckBox(Boolean.parseBoolean(data[18]));
		landfillTeleCBW.setCheckBox(Boolean.parseBoolean(data[19]));
		humanPlayerTeleCBW.setCheckBox(Boolean.parseBoolean(data[20]));
		highestStackArray = getResources().getStringArray(R.array.highest_possible_stack);
		highestStackSpinner.setSelection(Arrays.asList(highestStackArray).indexOf(data[21]));
	}*/
}
