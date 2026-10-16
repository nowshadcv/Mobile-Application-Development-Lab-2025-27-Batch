package com.first.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity package com.first.calculator;

        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View; // <-- Added missing import
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonDot, buttonC, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEql;

    EditText result;

    float mValueOne = Float.NaN, mValueTwo;
    boolean mAddition, mSubtract, mMultiplication, mDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        button0 = findViewById(R.id.buttonzero);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttondot);
        buttonC = findViewById(R.id.buttonC);
        buttonAdd = findViewById(R.id.buttonadd);
        buttonSub = findViewById(R.id.buttonsub);
        buttonMul = findViewById(R.id.buttonmul);
        buttonDiv = findViewById(R.id.buttondiv);
        buttonEql = findViewById(R.id.buttoneql);

        // Initialize result display
        result = findViewById(R.id.edit1);

        // Number buttons
        View.OnClickListener numberListener = v -> {
            Button b = (Button) v;
            result.setText(result.getText().toString() + b.getText().toString());
        };

        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);

        buttonDot.setOnClickListener(v -> {
            String currentText = result.getText().toString();
            if (!currentText.contains(".")) {
                if (currentText.isEmpty()) {
                    result.setText("0.");
                } else {
                    result.setText(currentText + ".");
                }
            }
        });

        // Operator helper
        View.OnClickListener operatorListener = v -> {
            if (!result.getText().toString().isEmpty()) {
                if (!Float.isNaN(mValueOne)) {
                    mValueTwo = Float.parseFloat(result.getText().toString());
                    computeCalculation();
                } else {
                    mValueOne = Float.parseFloat(result.getText().toString());
                }

                Button b = (Button) v;
                String op = b.getText().toString();

                mAddition = op.equals("+");
                mSubtract = op.equals("-");
                mMultiplication = op.equals("×") || op.equals("*");
                mDivision = op.equals("/");

                result.setText("");
            }
        };

        buttonAdd.setOnClickListener(operatorListener);
        buttonSub.setOnClickListener(operatorListener);
        buttonMul.setOnClickListener(operatorListener);
        buttonDiv.setOnClickListener(operatorListener);

        // Equal button
        buttonEql.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty() && !Float.isNaN(mValueOne)) {
                mValueTwo = Float.parseFloat(result.getText().toString());
                computeCalculation();
                mValueOne = Float.NaN;
                mAddition = mSubtract = mMultiplication = mDivision = false;
            }
        });

        // Clear button
        buttonC.setOnClickListener(v -> {
            result.setText("");
            mValueOne = Float.NaN;
            mValueTwo = 0;
            mAddition = false;
            mSubtract = false;
            mMultiplication = false;
            mDivision = false;
        });
    }

    private void computeCalculation() {
        if (mAddition) {
            mValueOne = mValueOne + mValueTwo;
        } else if (mSubtract) {
            mValueOne = mValueOne - mValueTwo;
        } else if (mMultiplication) {
            mValueOne = mValueOne * mValueTwo;
        } else if (mDivision) {
            if (mValueTwo != 0) {
                mValueOne = mValueOne / mValueTwo;
            } else {
                result.setText("Error");
                return;
            }
        }
        result.setText(String.valueOf(mValueOne));
    }
}