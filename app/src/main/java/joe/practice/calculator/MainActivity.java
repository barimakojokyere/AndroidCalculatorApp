package joe.practice.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare variables outside onCreate function
    private EditText entryEditText;
    private TextView resultTextView;
    private float currentNum; //defines current number
    private float previousNum; //defines previous number
    private float finalAnswer; //stores final answer
    private String operation; //indicates which mathematical operation is being carried out
    private boolean afterOperation; //true if any operation button has been hit, otherwise false
    private boolean afterEqual; //true if equal to sign has been hit, otherwise false
    ArrayList<Integer> numbersList = new ArrayList<Integer>();
    ArrayList<Integer> oneOpreationList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize variables in onCreate function
        entryEditText = (EditText) findViewById(R.id.entryEditText);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        previousNum = -1;
        currentNum = -1;
        afterOperation = false;
        afterEqual = false;
        operation = "";

        // Add number buttons to list
        numbersList.add(R.id.zeroBtn);
        numbersList.add(R.id.oneBtn);
        numbersList.add(R.id.twoBtn);
        numbersList.add(R.id.threeBtn);
        numbersList.add(R.id.fourBtn);
        numbersList.add(R.id.fiveBtn);
        numbersList.add(R.id.sixBtn);
        numbersList.add(R.id.sevenBtn);
        numbersList.add(R.id.eightBtn);
        numbersList.add(R.id.nineBtn);

        // Add buttons for one operation
        oneOpreationList.add(R.id.sqrtBtn);
        oneOpreationList.add(R.id.squareBtn);
        oneOpreationList.add(R.id.percentBtn);
        oneOpreationList.add(R.id.cubedBtn);
        oneOpreationList.add(R.id.reciprocalBtn);
        oneOpreationList.add(R.id.delBtn);

        /* Initialize Buttons in onCreate function to create buttons
           use buttonVariableName.setOnClickListener(this) to put the button in listening mode
        */
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);
        zeroBtn.setOnClickListener(this);
        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        oneBtn.setOnClickListener(this);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        twoBtn.setOnClickListener(this);
        Button threeBtn = (Button) findViewById(R.id.threeBtn);
        threeBtn.setOnClickListener(this);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        fourBtn.setOnClickListener(this);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        fiveBtn.setOnClickListener(this);
        Button sixBtn = (Button) findViewById(R.id.sixBtn);
        sixBtn.setOnClickListener(this);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        sevenBtn.setOnClickListener(this);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        eightBtn.setOnClickListener(this);
        Button nineBtn = (Button) findViewById(R.id.nineBtn);
        nineBtn.setOnClickListener(this);
        Button dotBtn = (Button) findViewById(R.id.dotBtn);
        dotBtn.setOnClickListener(this);
        Button plusBtn = (Button) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(this);
        Button minusBtn = (Button) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(this);
        Button timesBtn = (Button) findViewById(R.id.timesBtn);
        timesBtn.setOnClickListener(this);
        Button divideBtn = (Button) findViewById(R.id.divideBtn);
        divideBtn.setOnClickListener(this);
        Button equalBtn = (Button) findViewById(R.id.equalBtn);
        equalBtn.setOnClickListener(this);
        Button clearBtn = (Button) findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(this);
        Button sqrtBtn = (Button) findViewById(R.id.sqrtBtn);
        sqrtBtn.setOnClickListener(this);
        Button squareBtn = (Button) findViewById(R.id.squareBtn);
        squareBtn.setOnClickListener(this);
        Button percentBtn = (Button) findViewById(R.id.percentBtn);
        percentBtn.setOnClickListener(this);
        Button cubedBtn = (Button) findViewById(R.id.cubedBtn);
        cubedBtn.setOnClickListener(this);
        Button reciprocalBtn = (Button) findViewById(R.id.reciprocalBtn);
        reciprocalBtn.setOnClickListener(this);
        Button delBtn = (Button) findViewById(R.id.delBtn);
        delBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int entryLength;
        String entryPlaceHolder;

        // For numbers 0 to 9
        if (numbersList.contains(v.getId())) {

            //reset values when equal button is pressed
            if (afterEqual){
                entryEditText.getText().clear();
                resultTextView.setText("");
                afterEqual = false;
                previousNum = -1;
                currentNum = -1;
            }

            //clear entry when operation button is pressed
            if (afterOperation) {
                entryEditText.getText().clear();
            }

            switch (v.getId()) {
                case R.id.zeroBtn:
                    appendNumber(0);
                    break;
                case R.id.oneBtn:
                    appendNumber(1);
                    break;
                case R.id.twoBtn:
                    appendNumber(2);
                    break;
                case R.id.threeBtn:
                    appendNumber(3);
                    break;
                case R.id.fourBtn:
                    appendNumber(4);
                    break;
                case R.id.fiveBtn:
                    appendNumber(5);
                    break;
                case R.id.sixBtn:
                    appendNumber(6);
                    break;
                case R.id.sevenBtn:
                    appendNumber(7);
                    break;
                case R.id.eightBtn:
                    appendNumber(8);
                    break;
                default:
                    appendNumber(9);
                    break;
            }

            if(previousNum != -1){
                finalAnswer = (float) undertakeOperation(previousNum, currentNum, operation);
                resultTextView.setText(String.valueOf(finalAnswer));
                currentNum = (float)finalAnswer;
            }
        }
        // For one value operations such as square root, absolute value etc. as well as delete
        else if(oneOpreationList.contains(v.getId())) {

            switch(v.getId()){
                case R.id.sqrtBtn:
                    selectOperationForSingle("sqrt");
                    break;
                case R.id.squareBtn:
                    selectOperationForSingle("square");
                    break;
                case R.id.percentBtn:
                    selectOperationForSingle("percent");
                    break;
                case R.id.reciprocalBtn:
                    selectOperationForSingle("reciprocal");
                    break;
                case R.id.cubedBtn:
                    selectOperationForSingle("cubed");
                    break;
                default:
                    if (!afterEqual) {
                        entryLength = entryEditText.getText().length();
                        if (entryLength <= 1) {
                            entryEditText.getText().clear();
                            if(!operation.equals("\\u00F7") && !operation.equals("x") ) {
                                currentNum = 0;
                            }else{
                                currentNum = 1;
                            }
                        } else {
                            entryPlaceHolder = entryEditText.getText().toString().substring(0, entryLength - 1);
                            entryEditText.getText().clear();
                            entryEditText.append(entryPlaceHolder);
                            currentNum = Float.parseFloat(entryEditText.getText().toString());
                        }
                        afterOperation = false;
                    }
                    break;
            }
            if((previousNum != -1) && !afterEqual){
                finalAnswer = (float) undertakeOperation(previousNum, currentNum, operation);
                resultTextView.setText(String.valueOf(finalAnswer));
                currentNum = (float)finalAnswer;
            }
        }
        // For two number operations such as addition, subtraction etc and period.
        else {
            switch (v.getId()) {
                    case R.id.dotBtn:
                        entryEditText.append(".");
                        break;
                    case R.id.plusBtn:
                        selectOperation("+");
                        break;
                    case R.id.minusBtn:
                        selectOperation("-");
                        break;
                    case R.id.timesBtn:
                        selectOperation("x");
                        break;
                    case R.id.divideBtn:
                        selectOperation("\\u00F7");
                        break;
                    case R.id.equalBtn:
                        entryEditText.getText().clear();
                        resultTextView.setText("");
                        entryEditText.append(String.valueOf(finalAnswer));
                        previousNum = currentNum;
                        afterEqual = true;
                        break;
                    default:
                        entryEditText.getText().clear();
                        resultTextView.setText("");
                        afterOperation = false;
                        afterEqual = false;
                        previousNum = -1;
                        currentNum = -1;
                        break;
                }
        }
    }

    // Append number to EditText field
    private void appendNumber(Integer number){
        entryEditText.append(String.valueOf(number));
        currentNum = Float.parseFloat(entryEditText.getText().toString());
        afterOperation = false;
    }

    // Select operation to use for operations involving two numbers
    private void selectOperation(String operationToUse){
        previousNum = currentNum;
        operation = operationToUse;
        afterOperation = true;
        afterEqual = false;
    }

    // Select operation to use for operations involving one numbers
    private void selectOperationForSingle(String operationToUse){
        previousNum = 0;
        currentNum = Float.parseFloat(entryEditText.getText().toString());
        operation = operationToUse;
        afterOperation = false;
    }

    // Does the actual computation
    private double undertakeOperation(float firstNum, float secondNum, String operation){
        float output = 0;

        switch (operation){
            case "+":
                output = firstNum + secondNum;
                break;
            case "-":
                output = firstNum - secondNum;
                break;
            case "x":
                output = firstNum * secondNum;
                break;
            case "\\u00F7":
                output = firstNum/secondNum;
                break;
            case "sqrt":
                output = (float)Math.sqrt(currentNum);
                break;
            case "square":
                output = (float) Math.pow((double)currentNum, 2.0);
                break;
            case "percent":
                output = currentNum/100;
                break;
            case "reciprocal":
                output = 1/currentNum;
                break;
            default:
                output = (float) Math.pow((double)currentNum, 3.0);
                break;
        }

        return output;
    }
}