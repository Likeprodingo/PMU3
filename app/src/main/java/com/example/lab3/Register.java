package com.example.lab3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, //Вызывается при создании View
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_register, container, false); //Получаем view

        Button ExitButton = (Button) view.findViewById(R.id.BackBtn); //Получаем кнопку выхода
        final TextView AlertTitle = (TextView) view.findViewById(R.id.AlertTitle); //Получаем поле для вывода ошибок
        Button ConfirmButton = (Button) view.findViewById(R.id.ConfirmBtn); //Получаем кнопку регистрации

        ExitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                returnToPrevious();
            }
        });//Если нажата кнопка выхода

        ConfirmButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            { //Если нажата кнопка регистрации
                EditText email = (EditText) getView().findViewById(R.id.LoginField); //Получаем поле ввода электронной почты
                EditText password = (EditText) getView().findViewById(R.id.PasswordField); //Получаем поле ввода пароля
                EditText passwordConfirm = (EditText) getView().findViewById(R.id.PaswordRepeat); //Получаем поле ввода повтора пароля
                EditText name = (EditText) getView().findViewById(R.id.NameField); //Получаем поле ввода имени

                //Валидация имени. Если оно не подходит под регулярное выражение (Английские и русские буквы, а так же символ -, в количестве от 3 до 16 символов)

                            LogIn.mLogin = email.getText().toString(); //Запомниить данные для входа
                            LogIn.mPassword = password.getText().toString();

            }

        });
        return view;
    }

    private void returnToPrevious(){ //Выход на логин
        Fragment fragment = null; //Создание фрагмента логина
        fragment = new LogIn();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.MainFragment, fragment); //Добавление в Activity
        fragmentTransaction.commit();
    }
}
