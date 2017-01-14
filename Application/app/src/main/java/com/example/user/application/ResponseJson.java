package com.example.user.application;

/**
 * Created by User on 2017-01-13.
 */
public class ResponseJson {

        private int response_x;
        private int response_y;
        private int response_z;
        private int response_l;

        public int getResponse_x () {
            return response_x;
        }

        public void setResponse_x (int response_x) {
            this.response_x = response_x;
        }

        public int getResponse_y () {
            return response_y;
        }

        public void setResponse_y (int response_y) {
            this.response_y = response_y;
        }

        public int getResponse_z (){
            return response_z;
        }

        public void setResponse_z (int response_z) {
            this.response_z = response_z;
        }

        public int getResponse_l (){
            return response_l;
        }

        public void setResponse_l (int response_l){
            this.response_l = response_l;
        }


        @Override
        public String toString() {
            return "return [response_x = " + response_x + ", response_y = " + response_y + ", response_z = "+response_z+",response_l = "+response_l+"]";
        }

    }
