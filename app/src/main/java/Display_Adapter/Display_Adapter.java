package Display_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.himanshu.firstapp.R;

import java.util.ArrayList;

import model.User;

/**
 * Created by himanshu on 31/3/17.
 */

public class Display_Adapter extends BaseAdapter {

    private Context context;
    ArrayList<User> userArrayList;

    public Display_Adapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.custome_layout, parent, false);

        User user = (User) getItem(position);
        TextView tvFirstName = (TextView) convertView.findViewById(R.id.first_Name_Id);
        TextView tvLastName = (TextView) convertView.findViewById(R.id.last_Name_Id);
        TextView tvEmailValue = (TextView) convertView.findViewById(R.id.email_id);
        TextView tvPassword = (TextView) convertView.findViewById(R.id.password_Id);
        TextView tvGenderValue = (TextView) convertView.findViewById(R.id.gender_Id);
        TextView tvMobile = (TextView) convertView.findViewById(R.id.mobile_No_Id);

        tvFirstName.setText(user.getFirstName());
        tvLastName.setText(user.getLastName());
        tvEmailValue.setText(user.getEmail());
        tvPassword.setText(user.getPassword());
        tvMobile.setText(user.getMobileNo());
        tvGenderValue.setText(user.getGender());
        return convertView;

    }
}
