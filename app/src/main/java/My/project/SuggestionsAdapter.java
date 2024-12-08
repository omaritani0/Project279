package My.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ArrayAdapter;



import java.util.ArrayList;

public class SuggestionsAdapter extends ArrayAdapter<Suggestion> {

    public SuggestionsAdapter(Context context, ArrayList<Suggestion> suggestions) {
        super(context, 0, suggestions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suggestion suggestion = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_suggestion, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.suggestion_image);
        TextView nameTextView = convertView.findViewById(R.id.suggestion_name);
        TextView positionTextView = convertView.findViewById(R.id.suggestion_position);

        // Set data
        nameTextView.setText(suggestion.getName());
        positionTextView.setText(suggestion.getPosition());

        return convertView;
    }
}
