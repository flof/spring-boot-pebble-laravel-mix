<template>
    <div id="h2-user">
        <div class="py-5 text-center">
            <div class="container">
                <div class="row">
                    <div class="mx-auto col-lg-8">
                        <h1>Usage</h1>
                        <p class="mb-4">
                            This is an example of a Larvel Mix and Spring Data Rest Repository. Enter the username and
                            display name in the form below and the data will be added to the H2 database.
                        </p>
                        <form class="form-inline d-flex justify-content-around">
                            <div class="form-group">
                                <input class="form-control" id="name" placeholder="Username"
                                       type="text" v-model="formUser.name"></div>
                            <div class="form-group">
                                <input class="form-control" id="display-name" placeholder="Display Name"
                                       type="text" v-model="formUser.displayName"
                                ></div>
                            <button @click="saveUser()" class="btn btn-primary" type="button">Add User</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">Users</div>
                            <div class="card-body">
                                <h4>People store in H2 database.</h4>
                                <p v-if="users.length === 0">No users</p>
                                <div class="table-responsive" v-if="users.length !== 0">
                                    <table class="table table-bordered ">
                                        <thead class="thead-dark">
                                        <tr>
                                            <th>Name</th>
                                            <th>Display Name</th>
                                            <!--<th>Operate</th>-->
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr v-for="user in users">
                                            <td v-text="user.name">Mark</td>
                                            <td v-text="user.displayName">Otto</td>
                                            <!--<td>-->
                                            <!--<button class="btn btn-link" @click="deleteUser(user.name)">Delete-->
                                            <!--</button>-->
                                            <!--</td>-->
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        mounted() {
            console.log('Component Mounted');
            this.getUsers();
        },
        data: function () {
            return {
                msg: '',
                formUser: {
                    name: '',
                    displayName: ''
                },
                users: []
            }
        },
        methods: {
            saveUser() {
                window.axios.post('/api/v1/people', this.formUser).then((response) => {
                    this.msg = "Update Successful";
                    this.getUsers();
                });
            },
            getUsers() {
                window.axios.get('/api/v1/people').then((response) => {
                    this.users = response.data._embedded.people;
                    console.log(this.users);
                });
            },
            deleteUser(id) {
                window.axios.delete('/api/v1/people/' + id).then((response) => {
                    this.getUsers();
                });
            }
        }
    }
</script>
