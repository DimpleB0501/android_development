package com.example.numbertype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ip;
    Button check, check_palindrome, check_prime, check_strong, check_armstrong;
    TextView op, op_palindrome, op_prime, op_strong, op_armstrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = findViewById(R.id.ip);
        check = findViewById(R.id.check);
        op = findViewById(R.id.op);
        check_palindrome  = findViewById(R.id.check_palindrome);
        op_palindrome = findViewById(R.id.op_palindrome);
        check_prime = findViewById(R.id.check_prime);
        op_prime = findViewById(R.id.op_prime);
        check_strong = findViewById(R.id.check_strong);
        op_strong = findViewById(R.id.op_strong);
        check_armstrong = findViewById(R.id.check_armstrong);
        op_armstrong = findViewById(R.id.op_armstrong);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(ip.getText().toString());
                if (num  % 2 == 0){
                    op.setText("Even Number");
                }
                else{
                    op.setText("Odd Number");
                }
            }
        });

        check_palindrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(ip.getText().toString());
                int reverse = 0, org_num, remainder;
                org_num = num;

                //reverse integer is stored in variable
                while (num !=0){
                    remainder = num % 10;
                    reverse = reverse * 10 + remainder;
                    num /= 10;
                }

                if (org_num == reverse){
                    op_palindrome.setText(org_num + " is a palindrome");
                }
                else{
                    op_palindrome.setText(org_num + " is not a palindrome");
                }
            }


        });

        check_prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(ip.getText().toString());
                boolean flag = false;
                for(int i = 2; i <= num/2; ++i)
                {
                    // condition for nonprime number
                    if(num % i == 0)
                    {
                        flag = true;
                        break;
                    }
                }

                if (!flag){
                    op_prime.setText(num + " is a prime number");
                }
                else {
                    op_prime.setText(num + " is not a prime number");
                }
            }


        });

        check_strong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(ip.getText().toString());
                int fac,sum = 0;
                int n = num;
                while(n != 0)
                {
                    fac = 1;
                    int r = n % 10;
                    //calculating factorial of r
                    for(int i = r ; i >= 1 ; i--)
                        fac = fac * i;
                    //storing sum of factorial of all digits of the number
                    sum = sum + fac;
                    n=n/10;
                }
                //condition for strong number
                if(sum == num)
                    op_strong.setText(num + " is a Strong Number");//display the result
                else
                    op_strong.setText(num + " is not a Strong Number");
            }
        });

        check_armstrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(ip.getText().toString());
                int org_num, remainder, result = 0;

                org_num = num;

                while (org_num != 0)
                {
                    remainder = org_num % 10;
                    result += Math.pow(remainder, 3);
                    org_num /= 10;
                }

                if(result == num)
                    op_armstrong.setText(num + " is an Armstrong number.");
                else
                    op_armstrong.setText(num  + " is not an Armstrong number.");
            }
        });
    }
}