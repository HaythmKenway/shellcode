<template>
  <section class="px-6">
    <div class="container h-full p-10">
      <h1 class="text-center pt-10 font-semibold text-transparent text-6xl bg-clip-text text-white flex justify-center">
        SHELLCODE
      </h1>
      <br />
      <br />
      <div class="g-6 flex h-full flex-wrap items-center justify-center text-neutral-800 dark:text-neutral-200">
        <div class="w-full">
          <div class="block rounded-lg bg-white shadow-lg dark:bg-neutral-800">
            <div class="g-0 lg:flex lg:flex-wrap">
              <!-- Left column container-->
              <div class="px-4 md:px-0 lg:w-6/12">
                <div class="md:mx-6 md:p-12">
                  <!--Logo-->
                  <div class="text-center">
                    <h1 class="font-bold text-3xl text-neutral-700 dark:text-neutral-200 mt-0">
                      Sign up
                    </h1>
                    <p class="text-neutral-500 dark:text-neutral-400 mb-6">
                      Create your account
                    </p>
                  </div>

                  <form @submit.prevent="submithandler">
                    <!--Username input-->
                    <div class="relative mb-4" data-te-input-wrapper-init>
                      <input type="text"
                        class="peer block min-h-[auto] w-full rounded border-0 bg-transparent px-3 py-[0.32rem] leading-[1.6] outline-none transition-all duration-200 ease-linear focus:placeholder:opacity-100 data-[te-input-state-active]:placeholder:opacity-100 motion-reduce:transition-none dark:placeholder:text-neutral-200 [&:not([data-te-input-placeholder-active])]:placeholder:opacity-0"
                        v-model="username" id="exampleFormControlInput1" placeholder="Username" required />
                      <label for="exampleFormControlInput1"
                        class="pointer-events-none absolute left-3 top-0 mb-0 max-w-[90%] origin-[0_0] truncate pt-[0.37rem] leading-[1.6] text-neutral-500 transition-all duration-200 ease-out peer-focus:-translate-y-[0.9rem] peer-focus:scale-[0.8] peer-focus:text-primary peer-data-[te-input-state-active]:-translate-y-[0.9rem] peer-data-[te-input-state-active]:scale-[0.8] motion-reduce:transition-none dark:text-neutral-200 dark:peer-focus:text-primary">Username<i
                          class="text-transparent">sadfasdfasdfdsfasdfasdfasdfasd</i>
                      </label>
                    </div>

                    <!--Email input-->
                    <div class="relative mb-4" data-te-input-wrapper-init>
                      <input type="email"
                        class="peer block min-h-[auto] w-full rounded border-0 bg-transparent px-3 py-[0.32rem] leading-[1.6] outline-none transition-all duration-200 ease-linear focus:placeholder:opacity-100 data-[te-input-state-active]:placeholder:opacity-100 motion-reduce:transition-none dark:placeholder:text-neutral-200 [&:not([data-te-input-placeholder-active])]:placeholder:opacity-0 mt-5"
                        v-model="email" id="exampleFormControlInput1" placeholder="Username" required />
                      <label for="exampleFormControlInput1"
                        class="pointer-events-none absolute left-3 top-0 mb-0 max-w-[90%] origin-[0_0] truncate pt-[0.37rem] leading-[1.6] text-neutral-500 transition-all duration-200 ease-out peer-focus:-translate-y-[0.9rem] peer-focus:scale-[0.8] peer-focus:text-primary peer-data-[te-input-state-active]:-translate-y-[0.9rem] peer-data-[te-input-state-active]:scale-[0.8] motion-reduce:transition-none dark:text-neutral-200 dark:peer-focus:text-primary">email<i
                          class="text-transparent">sadfasdfasdfdsfasdfasdfasdfasd</i>
                      </label>
                    </div>

                    <!--Password input-->
                    <div class="relative mb-4" data-te-input-wrapper-init>
                      <input @keyup="spcheck" type="password"
                        class="peer block min-h-[auto] w-full rounded border-0 bg-transparent px-3 py-[0.32rem] leading-[1.6] outline-none transition-all duration-200 ease-linear focus:placeholder:opacity-100 peer-focus:text-primary data-[te-input-state-active]:placeholder:opacity-100 motion-reduce:transition-none dark:text-neutral-200 dark:placeholder:text-neutral-200 dark:peer-focus:text-primary [&:not([data-te-input-placeholder-active])]:placeholder:opacity-0"
                        id="exampleFormControlInput11 mt-5" v-model="password" placeholder="Password" required />
                      <label for="exampleFormControlInput11"
                        class="pointer-events-none absolute left-3 top-0 mb-0 max-w-[90%] origin-[0_0] truncate pt-[0.37rem] leading-[1.6] text-neutral-500 transition-all duration-200 ease-out peer-focus:-translate-y-[0.9rem] peer-focus:scale-[0.8] peer-focus:text-primary peer-data-[te-input-state-active]:-translate-y-[0.9rem] peer-data-[te-input-state-active]:scale-[0.8] motion-reduce:transition-none dark:text-neutral-200 dark:peer-focus:text-primary">Password<i
                          class="text-transparent">sadfasdfasdfdsfasdfasdfasdfasd</i>
                      </label>
                    </div>
                    <p class="ml-9 mt-5">
                      <Icon v-if="password.length < 8" name="cil:check-circle" style="color: red" />
                      <Icon v-else name="cil:check-circle" style="color: green" />
                      Password must be atleast 8 characters
                    </p>

                    <p class="ml-9 mt-5">
                      <Icon v-if="!checksp" name="cil:check-circle" style="color: red" />
                      <Icon v-else name="cil:check-circle" style="color: green" />
                      Password must contain a special charecters
                    </p>

                    <p class="ml-9 mt-5">
                      <Icon v-if="!/\d/.test(password)" name="cil:check-circle" style="color: red" />
                      <Icon v-else name="cil:check-circle" style="color: green" />
                      Password must a contain number
                    </p>
                    <br />
                    <div class="relative mb-4" data-te-input-wrapper-init>
                      <input @keyup="spcheck" type="password"
                        class="peer block min-h-[auto] w-full rounded border-0 bg-transparent px-3 py-[0.32rem] leading-[1.6] outline-none transition-all duration-200 ease-linear focus:placeholder:opacity-100 peer-focus:text-primary data-[te-input-state-active]:placeholder:opacity-100 motion-reduce:transition-none dark:text-neutral-200 dark:placeholder:text-neutral-200 dark:peer-focus:text-primary [&:not([data-te-input-placeholder-active])]:placeholder:opacity-0"
                        id="exampleFormControlInput11 mt-5" v-model="cpassword" placeholder="Password" required />
                      <label for="exampleFormControlInput11"
                        class="pointer-events-none absolute left-3 top-0 mb-0 max-w-[90%] origin-[0_0] truncate pt-[0.37rem] leading-[1.6] text-neutral-500 transition-all duration-200 ease-out peer-focus:-translate-y-[0.9rem] peer-focus:scale-[0.8] peer-focus:text-primary peer-data-[te-input-state-active]:-translate-y-[0.9rem] peer-data-[te-input-state-active]:scale-[0.8] motion-reduce:transition-none dark:text-neutral-200 dark:peer-focus:text-primary">Confirm
                        Password<i class="text-transparent">sadfasdfasdfdsfasdfasdfasdfasd</i>
                      </label>
                    </div>

                    <p class="ml-9 mt-5">
                      <Icon v-if="cpassword !== password || password == ''" name="cil:check-circle" style="color: red" />
                      <Icon v-else name="cil:check-circle" style="color: green" />
                      Confirm password should be same as password
                    </p>

                    <!--mobile number-->
                    <div class="relative mb-4" data-te-input-wrapper-init>
                      <input type="number"
                        class="peer block min-h-[auto] w-full rounded border-0 bg-transparent px-3 py-[0.32rem] leading-[1.6] outline-none transition-all duration-200 ease-linear focus:placeholder:opacity-100 data-[te-input-state-active]:placeholder:opacity-100 motion-reduce:transition-none dark:placeholder:text-neutral-200 [&:not([data-te-input-placeholder-active])]:placeholder:opacity-0 mt-5"
                        v-model="number" id="exampleFormControlInput1" placeholder="Username" required />
                      <label for="exampleFormControlInput1"
                        class="pointer-events-none absolute left-3 top-0 mb-0 max-w-[90%] origin-[0_0] truncate pt-[0.37rem] leading-[1.6] text-neutral-500 transition-all duration-200 ease-out peer-focus:-translate-y-[0.9rem] peer-focus:scale-[0.8] peer-focus:text-primary peer-data-[te-input-state-active]:-translate-y-[0.9rem] peer-data-[te-input-state-active]:scale-[0.8] motion-reduce:transition-none dark:text-neutral-200 dark:peer-focus:text-primary">Mobile
                        Number
                        <i class="text-transparent">sadfasdfasdfdsfasdfasdfasdfasd</i>
                      </label>
                    </div>

                    <!--Submit button-->
                    <div class="mt-5 mb-12 pb-1 pt-1 text-center">
                      <button
                        class="mb-3 inline-block w-full rounded px-6 pb-2 pt-2.5 text-xs font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_rgba(0,0,0,0.2)] transition duration-150 ease-in-out hover:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)] focus:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)] focus:outline-none focus:ring-0 active:shadow-[0_8px_9px_-4px_rgba(0,0,0,0.1),0_4px_18px_0_rgba(0,0,0,0.2)]"
                        type="submit" data-te-ripple-init data-te-ripple-color="light" style="
                              background: linear-gradient(
                                to right,
                                #ee7724,
                                #d8363a,
                                #dd3675,
                                #b44593
                              );
                            " :disabled="submit">
                        Sign up
                      </button>
                    </div>

                    <!--Signin button-->
                    <div class="flex items-center justify-between pb-6">
                      <p class="mb-0 mr-2">Already have an account?</p>
                      <NuxtLink to="/Signin">
                        <button type="submit"
                          class="inline-block rounded border-2 border-danger px-6 pb-[6px] pt-2 text-xs font-medium uppercase leading-normal text-danger transition duration-150 ease-in-out hover:border-danger-600 hover:bg-neutral-500 hover:bg-opacity-10 hover:text-danger-600 focus:border-danger-600 focus:text-danger-600 focus:outline-none focus:ring-0 active:border-danger-700 active:text-danger-700 dark:hover:bg-neutral-100 dark:hover:bg-opacity-10"
                          data-te-ripple-init data-te-ripple-color="light">
                          Signin
                        </button>
                      </NuxtLink>
                    </div>

                  </form>
                </div>
              </div>

              <!-- Right column container with background and description-->
              <div class="flex items-center rounded-b-lg lg:w-6/12 lg:rounded-r-lg lg:rounded-bl-none" style="
                      background: linear-gradient(
                        to right,
                        #ee7724,
                        #d8363a,
                        #dd3675,
                        #b44593
                      );
                    ">
                <div class="px-4 py-6 text-white md:mx-6 md:p-12 bg-transparent">
                  <h1 class="mb-6 text-xl font-semibold bg-transparent">
                    A decentralised application to make money by running
                    api's...
                  </h1>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import Cookies from "js-cookie";
export default {
  data() {
    return {
      jwtToken: Cookies.get("jwtToken") || "",
      // token : localStorage.getItem('token') || "",
      username: "",
      email: "",
      password: "",
      checksp: false,
      submit: true,
      cpassword: "",
      number: null,
    };
  },
  methods: {
    passcheck() {
      if (
        this.password.length > 7 &&
        this.checksp == true &&
        /\d/.test(this.password) == true &&
        this.password === this.cpassword
      ) {
        this.submit = false;
      } else {
        this.submit = true;
      }
    },

    async submithandler() {
      const data = {
        name: this.username,
        email: this.email,
        password: this.password,
        phone: String(this.number),
      };
      try {
        const response = await fetch(
          "http://localhost:8080/api/v1/user/register",
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
          }
        );

        if (response.ok) {
          // Successful login, handle the response
          const datas = await response.json();
          Cookies.set('jwtToken', datas.token);
          // localStorage.setItem("token", datas.token);
          this.$router.push("/home");
        } else {
          console.log(response);
          // Handle the error response
          console.log("Login failed");
        }
      } catch (error) {
        // Handle any network or other errors
        console.error("An error occurred:", error);
      }
      // console.log(data);
      // this.username = "";
      // this.email = "";
      // this.password = "";
      // this.checksp = false;
      // this.submit = true;
      // this.cpassword = "";
      // this.number = null;
    },
    spcheck() {
      const special = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
      this.checksp = special.test(this.password);
      this.passcheck();
    },
  },
};
</script>

<style>
button[disabled]:hover {
  cursor: not-allowed !important;
  opacity: 0.4;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>
