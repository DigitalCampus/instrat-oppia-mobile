/* 
 * This file is part of OppiaMobile - https://digital-campus.org/
 * 
 * OppiaMobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * OppiaMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OppiaMobile. If not, see <http://www.gnu.org/licenses/>.
 */

package org.digitalcampus.oppia.widgets.quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.instrat.oppia.R;
import org.digitalcampus.mobile.quiz.model.Response;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ShortAnswerWidget extends TextInputQuizWidget {

	public static final String TAG = ShortAnswerWidget.class.getSimpleName();
	
	public ShortAnswerWidget(Activity activity, View v, ViewGroup container) {
		init(activity, container ,R.layout.widget_quiz_shortanswer,v);
	}


	@Override
	public void setQuestionResponses(List<Response> responses, List<String> currentAnswers) {
		EditText et = (EditText) view.findViewById(R.id.responsetext);
		Iterator<String> itr = currentAnswers.iterator(); 
		while(itr.hasNext()) {
		    String answer = itr.next(); 
		    et.setText(answer);
		}
        hideOnFocusLoss(et);
	}
	
	public List<String> getQuestionResponses(List<Response> responses){
		EditText et = (EditText) view.findViewById(R.id.responsetext);
		if(et.getText().toString().trim().equals("")){
			return null;
		} else {
			List<String> response = new ArrayList<String>();
			response.add(et.getText().toString().trim());
			return response;
		}
	}

}
