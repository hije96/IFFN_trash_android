package com.example.user.application;

/**
 * Created by User on 2017-01-13.
 */
public class ResponseJson {

        private int response_flavor_1;
        private int response_flavor_2;
        private int response_flavor_3;
        private int response_flavor_4;
        private int response_idx;
        private int result;

        public int getResponse_flavor_1 () {
            return response_flavor_1;
        }

        public void setResponse_flavor_1 (int response_flavor_1) {
            this.response_flavor_1 = response_flavor_1;
        }

        public int getResponse_flavor_2 () {
            return response_flavor_2;
        }

        public void setResponse_flavor_2 (int response_flavor_2) {
            this.response_flavor_2 = response_flavor_2;
        }

        public int getResponse_flavor_3 (){
            return response_flavor_3;
        }

        public void setResponse_flavor_3 (int response_flavor_3) {
            this.response_flavor_3 = response_flavor_3;
        }

        public int getResponse_flavor_4 (){
            return response_flavor_4;
        }

        public void setResponse_flavor_4 (int response_flavor_4){
            this.response_flavor_4 = response_flavor_4;
        }
         public int getResponse_idx(){
        return response_idx;
    }

        public void setResponse_idx (int response_idx){
            this.response_idx = response_idx;
        }
        public int getResult (){
        return result;
    }

        public void setResult (int result){
        this.result = result;
        }


        @Override
        public String toString() {
            return "return [response_idx = "+response_idx+",response_flavor_1 = " + response_flavor_1 +
                    ", response_flavor_2 = " + response_flavor_2 + ", response_flavor_3 = "+response_flavor_3+
                    ", response_flavor_4 = "+response_flavor_4+ ",  result = "+result+"]";
        }

         }
